package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 旅游景点
 *
 * @author 
 * @email
 */
@TableName("jingdian")
public class JingdianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingdianEntity() {

	}

	public JingdianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 景点编号
     */
    @ColumnInfo(comment="景点编号",type="varchar(200)")
    @TableField(value = "jingdian_uuid_number")

    private String jingdianUuidNumber;


    /**
     * 景点名称
     */
    @ColumnInfo(comment="景点名称",type="varchar(200)")
    @TableField(value = "jingdian_name")

    private String jingdianName;


    /**
     * 景点类型
     */
    @ColumnInfo(comment="景点类型",type="int(11)")
    @TableField(value = "jingdian_types")

    private Integer jingdianTypes;


    /**
     * 景点图片
     */
    @ColumnInfo(comment="景点图片",type="varchar(200)")
    @TableField(value = "jingdian_photo")

    private String jingdianPhoto;


    /**
     * 景点地址
     */
    @ColumnInfo(comment="景点地址",type="varchar(200)")
    @TableField(value = "jingdian_address")

    private String jingdianAddress;


    /**
     * 价格/人
     */
    @ColumnInfo(comment="价格/人",type="decimal(10,2)")
    @TableField(value = "jingdian_money")

    private Double jingdianMoney;


    /**
     * 热度
     */
    @ColumnInfo(comment="热度",type="int(11)")
    @TableField(value = "jingdian_clicknum")

    private Integer jingdianClicknum;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 日程路线
     */
    @ColumnInfo(comment="日程路线",type="longtext")
    @TableField(value = "jingdian_text")

    private String jingdianText;


    /**
     * 旅游景点详情
     */
    @ColumnInfo(comment="旅游景点详情",type="longtext")
    @TableField(value = "jingdian_content")

    private String jingdianContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：景点编号
	 */
    public String getJingdianUuidNumber() {
        return jingdianUuidNumber;
    }
    /**
	 * 设置：景点编号
	 */

    public void setJingdianUuidNumber(String jingdianUuidNumber) {
        this.jingdianUuidNumber = jingdianUuidNumber;
    }
    /**
	 * 获取：景点名称
	 */
    public String getJingdianName() {
        return jingdianName;
    }
    /**
	 * 设置：景点名称
	 */

    public void setJingdianName(String jingdianName) {
        this.jingdianName = jingdianName;
    }
    /**
	 * 获取：景点类型
	 */
    public Integer getJingdianTypes() {
        return jingdianTypes;
    }
    /**
	 * 设置：景点类型
	 */

    public void setJingdianTypes(Integer jingdianTypes) {
        this.jingdianTypes = jingdianTypes;
    }
    /**
	 * 获取：景点图片
	 */
    public String getJingdianPhoto() {
        return jingdianPhoto;
    }
    /**
	 * 设置：景点图片
	 */

    public void setJingdianPhoto(String jingdianPhoto) {
        this.jingdianPhoto = jingdianPhoto;
    }
    /**
	 * 获取：景点地址
	 */
    public String getJingdianAddress() {
        return jingdianAddress;
    }
    /**
	 * 设置：景点地址
	 */

    public void setJingdianAddress(String jingdianAddress) {
        this.jingdianAddress = jingdianAddress;
    }
    /**
	 * 获取：价格/人
	 */
    public Double getJingdianMoney() {
        return jingdianMoney;
    }
    /**
	 * 设置：价格/人
	 */

    public void setJingdianMoney(Double jingdianMoney) {
        this.jingdianMoney = jingdianMoney;
    }
    /**
	 * 获取：热度
	 */
    public Integer getJingdianClicknum() {
        return jingdianClicknum;
    }
    /**
	 * 设置：热度
	 */

    public void setJingdianClicknum(Integer jingdianClicknum) {
        this.jingdianClicknum = jingdianClicknum;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getcaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setcaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：日程路线
	 */
    public String getJingdianText() {
        return jingdianText;
    }
    /**
	 * 设置：日程路线
	 */

    public void setJingdianText(String jingdianText) {
        this.jingdianText = jingdianText;
    }
    /**
	 * 获取：旅游景点详情
	 */
    public String getJingdianContent() {
        return jingdianContent;
    }
    /**
	 * 设置：旅游景点详情
	 */

    public void setJingdianContent(String jingdianContent) {
        this.jingdianContent = jingdianContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jingdian{" +
            ", id=" + id +
            ", jingdianUuidNumber=" + jingdianUuidNumber +
            ", jingdianName=" + jingdianName +
            ", jingdianTypes=" + jingdianTypes +
            ", jingdianPhoto=" + jingdianPhoto +
            ", jingdianAddress=" + jingdianAddress +
            ", jingdianMoney=" + jingdianMoney +
            ", jingdianClicknum=" + jingdianClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", jingdianText=" + jingdianText +
            ", jingdianContent=" + jingdianContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
