package com.entity.vo;

import com.entity.JingdianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 旅游景点
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jingdian")
public class JingdianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 景点编号
     */

    @TableField(value = "jingdian_uuid_number")
    private String jingdianUuidNumber;


    /**
     * 景点名称
     */

    @TableField(value = "jingdian_name")
    private String jingdianName;


    /**
     * 景点类型
     */

    @TableField(value = "jingdian_types")
    private Integer jingdianTypes;


    /**
     * 景点图片
     */

    @TableField(value = "jingdian_photo")
    private String jingdianPhoto;


    /**
     * 景点地址
     */

    @TableField(value = "jingdian_address")
    private String jingdianAddress;


    /**
     * 价格/人
     */

    @TableField(value = "jingdian_money")
    private Double jingdianMoney;


    /**
     * 热度
     */

    @TableField(value = "jingdian_clicknum")
    private Integer jingdianClicknum;


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
     * 日程路线
     */

    @TableField(value = "jingdian_text")
    private String jingdianText;


    /**
     * 旅游景点详情
     */

    @TableField(value = "jingdian_content")
    private String jingdianContent;


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
	 * 设置：景点编号
	 */
    public String getJingdianUuidNumber() {
        return jingdianUuidNumber;
    }


    /**
	 * 获取：景点编号
	 */

    public void setJingdianUuidNumber(String jingdianUuidNumber) {
        this.jingdianUuidNumber = jingdianUuidNumber;
    }
    /**
	 * 设置：景点名称
	 */
    public String getJingdianName() {
        return jingdianName;
    }


    /**
	 * 获取：景点名称
	 */

    public void setJingdianName(String jingdianName) {
        this.jingdianName = jingdianName;
    }
    /**
	 * 设置：景点类型
	 */
    public Integer getJingdianTypes() {
        return jingdianTypes;
    }


    /**
	 * 获取：景点类型
	 */

    public void setJingdianTypes(Integer jingdianTypes) {
        this.jingdianTypes = jingdianTypes;
    }
    /**
	 * 设置：景点图片
	 */
    public String getJingdianPhoto() {
        return jingdianPhoto;
    }


    /**
	 * 获取：景点图片
	 */

    public void setJingdianPhoto(String jingdianPhoto) {
        this.jingdianPhoto = jingdianPhoto;
    }
    /**
	 * 设置：景点地址
	 */
    public String getJingdianAddress() {
        return jingdianAddress;
    }


    /**
	 * 获取：景点地址
	 */

    public void setJingdianAddress(String jingdianAddress) {
        this.jingdianAddress = jingdianAddress;
    }
    /**
	 * 设置：价格/人
	 */
    public Double getJingdianMoney() {
        return jingdianMoney;
    }


    /**
	 * 获取：价格/人
	 */

    public void setJingdianMoney(Double jingdianMoney) {
        this.jingdianMoney = jingdianMoney;
    }
    /**
	 * 设置：热度
	 */
    public Integer getJingdianClicknum() {
        return jingdianClicknum;
    }


    /**
	 * 获取：热度
	 */

    public void setJingdianClicknum(Integer jingdianClicknum) {
        this.jingdianClicknum = jingdianClicknum;
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
	 * 设置：日程路线
	 */
    public String getJingdianText() {
        return jingdianText;
    }


    /**
	 * 获取：日程路线
	 */

    public void setJingdianText(String jingdianText) {
        this.jingdianText = jingdianText;
    }
    /**
	 * 设置：旅游景点详情
	 */
    public String getJingdianContent() {
        return jingdianContent;
    }


    /**
	 * 获取：旅游景点详情
	 */

    public void setJingdianContent(String jingdianContent) {
        this.jingdianContent = jingdianContent;
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
