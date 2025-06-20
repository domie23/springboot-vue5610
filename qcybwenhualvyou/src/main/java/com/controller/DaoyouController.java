
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 导游
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/daoyou")
public class DaoyouController {
    private static final Logger logger = LoggerFactory.getLogger(DaoyouController.class);

    private static final String TABLE_NAME = "daoyou";

    @Autowired
    private DaoyouService daoyouService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JingdianService jingdianService;//旅游景点
    @Autowired
    private JingdianCollectionService jingdianCollectionService;//旅游景点收藏
    @Autowired
    private JingdianLiuyanService jingdianLiuyanService;//旅游景点留言
    @Autowired
    private JiudianService jiudianService;//酒店信息
    @Autowired
    private JiudianCollectionService jiudianCollectionService;//酒店收藏
    @Autowired
    private JiudianLiuyanService jiudianLiuyanService;//酒店留言
    @Autowired
    private JiudianYuyueService jiudianYuyueService;//酒店预定
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private YonghuService yonghuService;//游客
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("游客".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("导游".equals(role))
            params.put("daoyouId",request.getSession().getAttribute("userId"));
        params.put("daoyouDeleteStart",1);params.put("daoyouDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = daoyouService.queryPage(params);

        //字典表数据转换
        List<DaoyouView> list =(List<DaoyouView>)page.getList();
        for(DaoyouView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DaoyouEntity daoyou = daoyouService.selectById(id);
        if(daoyou !=null){
            //entity转view
            DaoyouView view = new DaoyouView();
            BeanUtils.copyProperties( daoyou , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DaoyouEntity daoyou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,daoyou:{}",this.getClass().getName(),daoyou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DaoyouEntity> queryWrapper = new EntityWrapper<DaoyouEntity>()
            .eq("username", daoyou.getUsername())
            .or()
            .eq("daoyou_phone", daoyou.getDaoyouPhone())
            .eq("daoyou_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaoyouEntity daoyouEntity = daoyouService.selectOne(queryWrapper);
        if(daoyouEntity==null){
            daoyou.setDaoyouDelete(1);
            daoyou.setCreateTime(new Date());
            daoyou.setPassword("123456");
            daoyouService.insert(daoyou);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DaoyouEntity daoyou, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,daoyou:{}",this.getClass().getName(),daoyou.toString());
        DaoyouEntity oldDaoyouEntity = daoyouService.selectById(daoyou.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(daoyou.getDaoyouPhoto()) || "null".equals(daoyou.getDaoyouPhoto())){
                daoyou.setDaoyouPhoto(null);
        }

            daoyouService.updateById(daoyou);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DaoyouEntity> oldDaoyouList =daoyouService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DaoyouEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DaoyouEntity daoyouEntity = new DaoyouEntity();
            daoyouEntity.setId(id);
            daoyouEntity.setDaoyouDelete(2);
            list.add(daoyouEntity);
        }
        if(list != null && list.size() >0){
            daoyouService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<DaoyouEntity> daoyouList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DaoyouEntity daoyouEntity = new DaoyouEntity();
//                            daoyouEntity.setUsername(data.get(0));                    //账户 要改的
//                            daoyouEntity.setPassword("123456");//密码
//                            daoyouEntity.setDaoyouName(data.get(0));                    //导游姓名 要改的
//                            daoyouEntity.setDaoyouPhoto("");//详情和图片
//                            daoyouEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            daoyouEntity.setDaoyouPhone(data.get(0));                    //联系方式 要改的
//                            daoyouEntity.setDaoyouEmail(data.get(0));                    //邮箱 要改的
//                            daoyouEntity.setDaoyouDelete(1);//逻辑删除字段
//                            daoyouEntity.setCreateTime(date);//时间
                            daoyouList.add(daoyouEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("daoyouPhone")){
                                    List<String> daoyouPhone = seachFields.get("daoyouPhone");
                                    daoyouPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> daoyouPhone = new ArrayList<>();
                                    daoyouPhone.add(data.get(0));//要改的
                                    seachFields.put("daoyouPhone",daoyouPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<DaoyouEntity> daoyouEntities_username = daoyouService.selectList(new EntityWrapper<DaoyouEntity>().in("username", seachFields.get("username")).eq("daoyou_delete", 1));
                        if(daoyouEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DaoyouEntity s:daoyouEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<DaoyouEntity> daoyouEntities_daoyouPhone = daoyouService.selectList(new EntityWrapper<DaoyouEntity>().in("daoyou_phone", seachFields.get("daoyouPhone")).eq("daoyou_delete", 1));
                        if(daoyouEntities_daoyouPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DaoyouEntity s:daoyouEntities_daoyouPhone){
                                repeatFields.add(s.getDaoyouPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        daoyouService.insertBatch(daoyouList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        DaoyouEntity daoyou = daoyouService.selectOne(new EntityWrapper<DaoyouEntity>().eq("username", username));
        if(daoyou==null || !daoyou.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(daoyou.getDaoyouDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(daoyou.getId(),username, "daoyou", "导游");
        R r = R.ok();
        r.put("token", token);
        r.put("role","导游");
        r.put("username",daoyou.getDaoyouName());
        r.put("tableName","daoyou");
        r.put("userId",daoyou.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody DaoyouEntity daoyou, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<DaoyouEntity> queryWrapper = new EntityWrapper<DaoyouEntity>()
            .eq("username", daoyou.getUsername())
            .or()
            .eq("daoyou_phone", daoyou.getDaoyouPhone())
            .andNew()
            .eq("daoyou_delete", 1)
            ;
        DaoyouEntity daoyouEntity = daoyouService.selectOne(queryWrapper);
        if(daoyouEntity != null)
            return R.error("账户或者联系方式已经被使用");
        daoyou.setDaoyouDelete(1);
        daoyou.setCreateTime(new Date());
        daoyouService.insert(daoyou);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        DaoyouEntity daoyou = daoyouService.selectById(id);
        daoyou.setPassword("123456");
        daoyouService.updateById(daoyou);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        DaoyouEntity daoyou = daoyouService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(daoyou.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(daoyou.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        daoyou.setPassword(newPassword);
		daoyouService.updateById(daoyou);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        DaoyouEntity daoyou = daoyouService.selectOne(new EntityWrapper<DaoyouEntity>().eq("username", username));
        if(daoyou!=null){
            daoyou.setPassword("123456");
            daoyouService.updateById(daoyou);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrDaoyou(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        DaoyouEntity daoyou = daoyouService.selectById(id);
        if(daoyou !=null){
            //entity转view
            DaoyouView view = new DaoyouView();
            BeanUtils.copyProperties( daoyou , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = daoyouService.queryPage(params);

        //字典表数据转换
        List<DaoyouView> list =(List<DaoyouView>)page.getList();
        for(DaoyouView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DaoyouEntity daoyou = daoyouService.selectById(id);
            if(daoyou !=null){


                //entity转view
                DaoyouView view = new DaoyouView();
                BeanUtils.copyProperties( daoyou , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody DaoyouEntity daoyou, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,daoyou:{}",this.getClass().getName(),daoyou.toString());
        Wrapper<DaoyouEntity> queryWrapper = new EntityWrapper<DaoyouEntity>()
            .eq("username", daoyou.getUsername())
            .or()
            .eq("daoyou_phone", daoyou.getDaoyouPhone())
            .andNew()
            .eq("daoyou_delete", 1)
//            .notIn("daoyou_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaoyouEntity daoyouEntity = daoyouService.selectOne(queryWrapper);
        if(daoyouEntity==null){
            daoyou.setDaoyouDelete(1);
            daoyou.setCreateTime(new Date());
            daoyou.setPassword("123456");
        daoyouService.insert(daoyou);

            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

}

