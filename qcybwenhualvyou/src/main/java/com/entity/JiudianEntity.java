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
 * 酒店信息
 *
 * @author 
 * @email
 */
@TableName("jiudian")
public class JiudianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiudianEntity() {

	}

	public JiudianEntity(T t) {
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
     * 酒店名称
     */
    @ColumnInfo(comment="酒店名称",type="varchar(200)")
    @TableField(value = "jiudian_name")

    private String jiudianName;


    /**
     * 房间类型
     */
    @ColumnInfo(comment="房间类型",type="int(11)")
    @TableField(value = "jiudian_types")

    private Integer jiudianTypes;


    /**
     * 价格/天
     */
    @ColumnInfo(comment="价格/天",type="decimal(10,2)")
    @TableField(value = "jiudian_money")

    private Double jiudianMoney;


    /**
     * 酒店图片
     */
    @ColumnInfo(comment="酒店图片",type="varchar(200)")
    @TableField(value = "jiudian_photo")

    private String jiudianPhoto;


    /**
     * 酒店地址
     */
    @ColumnInfo(comment="酒店地址",type="varchar(200)")
    @TableField(value = "jiudian_address")

    private String jiudianAddress;


    /**
     * 热度
     */
    @ColumnInfo(comment="热度",type="int(11)")
    @TableField(value = "jiudian_clicknum")

    private Integer jiudianClicknum;


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
     * 冻结状态
     */
    @ColumnInfo(comment="冻结状态",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 酒店详情
     */
    @ColumnInfo(comment="酒店详情",type="longtext")
    @TableField(value = "jiudian_content")

    private String jiudianContent;


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
	 * 获取：酒店名称
	 */
    public String getJiudianName() {
        return jiudianName;
    }
    /**
	 * 设置：酒店名称
	 */

    public void setJiudianName(String jiudianName) {
        this.jiudianName = jiudianName;
    }
    /**
	 * 获取：房间类型
	 */
    public Integer getJiudianTypes() {
        return jiudianTypes;
    }
    /**
	 * 设置：房间类型
	 */

    public void setJiudianTypes(Integer jiudianTypes) {
        this.jiudianTypes = jiudianTypes;
    }
    /**
	 * 获取：价格/天
	 */
    public Double getJiudianMoney() {
        return jiudianMoney;
    }
    /**
	 * 设置：价格/天
	 */

    public void setJiudianMoney(Double jiudianMoney) {
        this.jiudianMoney = jiudianMoney;
    }
    /**
	 * 获取：酒店图片
	 */
    public String getJiudianPhoto() {
        return jiudianPhoto;
    }
    /**
	 * 设置：酒店图片
	 */

    public void setJiudianPhoto(String jiudianPhoto) {
        this.jiudianPhoto = jiudianPhoto;
    }
    /**
	 * 获取：酒店地址
	 */
    public String getJiudianAddress() {
        return jiudianAddress;
    }
    /**
	 * 设置：酒店地址
	 */

    public void setJiudianAddress(String jiudianAddress) {
        this.jiudianAddress = jiudianAddress;
    }
    /**
	 * 获取：热度
	 */
    public Integer getJiudianClicknum() {
        return jiudianClicknum;
    }
    /**
	 * 设置：热度
	 */

    public void setJiudianClicknum(Integer jiudianClicknum) {
        this.jiudianClicknum = jiudianClicknum;
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
	 * 获取：冻结状态
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：冻结状态
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：酒店详情
	 */
    public String getJiudianContent() {
        return jiudianContent;
    }
    /**
	 * 设置：酒店详情
	 */

    public void setJiudianContent(String jiudianContent) {
        this.jiudianContent = jiudianContent;
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
        return "Jiudian{" +
            ", id=" + id +
            ", jiudianName=" + jiudianName +
            ", jiudianTypes=" + jiudianTypes +
            ", jiudianMoney=" + jiudianMoney +
            ", jiudianPhoto=" + jiudianPhoto +
            ", jiudianAddress=" + jiudianAddress +
            ", jiudianClicknum=" + jiudianClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", shangxiaTypes=" + shangxiaTypes +
            ", jiudianContent=" + jiudianContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
