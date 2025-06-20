package com.entity.vo;

import com.entity.JiudianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 酒店信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiudian")
public class JiudianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 酒店名称
     */

    @TableField(value = "jiudian_name")
    private String jiudianName;


    /**
     * 房间类型
     */

    @TableField(value = "jiudian_types")
    private Integer jiudianTypes;


    /**
     * 价格/天
     */

    @TableField(value = "jiudian_money")
    private Double jiudianMoney;


    /**
     * 酒店图片
     */

    @TableField(value = "jiudian_photo")
    private String jiudianPhoto;


    /**
     * 酒店地址
     */

    @TableField(value = "jiudian_address")
    private String jiudianAddress;


    /**
     * 热度
     */

    @TableField(value = "jiudian_clicknum")
    private Integer jiudianClicknum;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 冻结状态
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 酒店详情
     */

    @TableField(value = "jiudian_content")
    private String jiudianContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：酒店名称
	 */
    public String getJiudianName() {
        return jiudianName;
    }


    /**
	 * 获取：酒店名称
	 */

    public void setJiudianName(String jiudianName) {
        this.jiudianName = jiudianName;
    }
    /**
	 * 设置：房间类型
	 */
    public Integer getJiudianTypes() {
        return jiudianTypes;
    }


    /**
	 * 获取：房间类型
	 */

    public void setJiudianTypes(Integer jiudianTypes) {
        this.jiudianTypes = jiudianTypes;
    }
    /**
	 * 设置：价格/天
	 */
    public Double getJiudianMoney() {
        return jiudianMoney;
    }


    /**
	 * 获取：价格/天
	 */

    public void setJiudianMoney(Double jiudianMoney) {
        this.jiudianMoney = jiudianMoney;
    }
    /**
	 * 设置：酒店图片
	 */
    public String getJiudianPhoto() {
        return jiudianPhoto;
    }


    /**
	 * 获取：酒店图片
	 */

    public void setJiudianPhoto(String jiudianPhoto) {
        this.jiudianPhoto = jiudianPhoto;
    }
    /**
	 * 设置：酒店地址
	 */
    public String getJiudianAddress() {
        return jiudianAddress;
    }


    /**
	 * 获取：酒店地址
	 */

    public void setJiudianAddress(String jiudianAddress) {
        this.jiudianAddress = jiudianAddress;
    }
    /**
	 * 设置：热度
	 */
    public Integer getJiudianClicknum() {
        return jiudianClicknum;
    }


    /**
	 * 获取：热度
	 */

    public void setJiudianClicknum(Integer jiudianClicknum) {
        this.jiudianClicknum = jiudianClicknum;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getcaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setcaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：冻结状态
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：冻结状态
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：酒店详情
	 */
    public String getJiudianContent() {
        return jiudianContent;
    }


    /**
	 * 获取：酒店详情
	 */

    public void setJiudianContent(String jiudianContent) {
        this.jiudianContent = jiudianContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
