
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
 * 酒店信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiudian")
public class JiudianController {
    private static final Logger logger = LoggerFactory.getLogger(JiudianController.class);

    private static final String TABLE_NAME = "jiudian";

    @Autowired
    private JiudianService jiudianService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DaoyouService daoyouService;//导游
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
        CommonUtil.checkMap(params);
        PageUtils page = jiudianService.queryPage(params);

        //字典表数据转换
        List<JiudianView> list =(List<JiudianView>)page.getList();
        for(JiudianView c:list){
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
        JiudianEntity jiudian = jiudianService.selectById(id);
        if(jiudian !=null){
            //entity转view
            JiudianView view = new JiudianView();
            BeanUtils.copyProperties( jiudian , view );//把实体数据重构到view中
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
    public R save(@RequestBody JiudianEntity jiudian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiudian:{}",this.getClass().getName(),jiudian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiudianEntity> queryWrapper = new EntityWrapper<JiudianEntity>()
            .eq("jiudian_name", jiudian.getJiudianName())
            .eq("jiudian_types", jiudian.getJiudianTypes())
            .eq("jiudian_address", jiudian.getJiudianAddress())
            .eq("zan_number", jiudian.getZanNumber())
            .eq("cai_number", jiudian.getcaiNumber())
            .eq("shangxia_types", jiudian.getShangxiaTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiudianEntity jiudianEntity = jiudianService.selectOne(queryWrapper);
        if(jiudianEntity==null){
            jiudian.setJiudianClicknum(1);
            jiudian.setShangxiaTypes(1);
            jiudian.setCreateTime(new Date());
            jiudianService.insert(jiudian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiudianEntity jiudian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiudian:{}",this.getClass().getName(),jiudian.toString());
        JiudianEntity oldJiudianEntity = jiudianService.selectById(jiudian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jiudian.getJiudianPhoto()) || "null".equals(jiudian.getJiudianPhoto())){
                jiudian.setJiudianPhoto(null);
        }

            jiudianService.updateById(jiudian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiudianEntity> oldJiudianList =jiudianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiudianService.deleteBatchIds(Arrays.asList(ids));

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
            List<JiudianEntity> jiudianList = new ArrayList<>();//上传的东西
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
                            JiudianEntity jiudianEntity = new JiudianEntity();
//                            jiudianEntity.setJiudianName(data.get(0));                    //酒店名称 要改的
//                            jiudianEntity.setJiudianTypes(Integer.valueOf(data.get(0)));   //房间类型 要改的
//                            jiudianEntity.setJiudianMoney(data.get(0));                    //价格/天 要改的
//                            jiudianEntity.setJiudianPhoto("");//详情和图片
//                            jiudianEntity.setJiudianAddress(data.get(0));                    //酒店地址 要改的
//                            jiudianEntity.setJiudianClicknum(Integer.valueOf(data.get(0)));   //热度 要改的
//                            jiudianEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            jiudianEntity.setcaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            jiudianEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //冻结状态 要改的
//                            jiudianEntity.setJiudianContent("");//详情和图片
//                            jiudianEntity.setCreateTime(date);//时间
                            jiudianList.add(jiudianEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiudianService.insertBatch(jiudianList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<JiudianView> returnJiudianViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = jiudianCollectionService.queryPage(params1);
        List<JiudianCollectionView> collectionViewsList =(List<JiudianCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(JiudianCollectionView collectionView:collectionViewsList){
            Integer jiudianTypes = collectionView.getJiudianTypes();
            if(typeMap.containsKey(jiudianTypes)){
                typeMap.put(jiudianTypes,typeMap.get(jiudianTypes)+1);
            }else{
                typeMap.put(jiudianTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("jiudianTypes",type);
            PageUtils pageUtils1 = jiudianService.queryPage(params2);
            List<JiudianView> jiudianViewList =(List<JiudianView>)pageUtils1.getList();
            returnJiudianViewList.addAll(jiudianViewList);
            if(returnJiudianViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = jiudianService.queryPage(params);
        if(returnJiudianViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnJiudianViewList.size();//要添加的数量
            List<JiudianView> jiudianViewList =(List<JiudianView>)page.getList();
            for(JiudianView jiudianView:jiudianViewList){
                Boolean addFlag = true;
                for(JiudianView returnJiudianView:returnJiudianViewList){
                    if(returnJiudianView.getId().intValue() ==jiudianView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnJiudianViewList.add(jiudianView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnJiudianViewList = returnJiudianViewList.subList(0, limit);
        }

        for(JiudianView c:returnJiudianViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnJiudianViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiudianService.queryPage(params);

        //字典表数据转换
        List<JiudianView> list =(List<JiudianView>)page.getList();
        for(JiudianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiudianEntity jiudian = jiudianService.selectById(id);
            if(jiudian !=null){

                //点击数量加1
                jiudian.setJiudianClicknum(jiudian.getJiudianClicknum()+1);
                jiudianService.updateById(jiudian);

                //entity转view
                JiudianView view = new JiudianView();
                BeanUtils.copyProperties( jiudian , view );//把实体数据重构到view中

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
    public R add(@RequestBody JiudianEntity jiudian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiudian:{}",this.getClass().getName(),jiudian.toString());
        Wrapper<JiudianEntity> queryWrapper = new EntityWrapper<JiudianEntity>()
            .eq("jiudian_name", jiudian.getJiudianName())
            .eq("jiudian_types", jiudian.getJiudianTypes())
            .eq("jiudian_address", jiudian.getJiudianAddress())
            .eq("jiudian_clicknum", jiudian.getJiudianClicknum())
            .eq("zan_number", jiudian.getZanNumber())
            .eq("cai_number", jiudian.getcaiNumber())
            .eq("shangxia_types", jiudian.getShangxiaTypes())
//            .notIn("jiudian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiudianEntity jiudianEntity = jiudianService.selectOne(queryWrapper);
        if(jiudianEntity==null){
            jiudian.setJiudianClicknum(1);
                jiudian.setZanNumber(1);
            jiudian.setCreateTime(new Date());
        jiudianService.insert(jiudian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

