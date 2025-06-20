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
 * 导游
 *
 * @author 
 * @email
 */
@TableName("daoyou")
public class DaoyouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DaoyouEntity() {

	}

	public DaoyouEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 导游姓名
     */
    @ColumnInfo(comment="导游姓名",type="varchar(200)")
    @TableField(value = "daoyou_name")

    private String daoyouName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(255)")
    @TableField(value = "daoyou_photo")

    private String daoyouPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "daoyou_phone")

    private String daoyouPhone;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "daoyou_email")

    private String daoyouEmail;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "daoyou_delete")

    private Integer daoyouDelete;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：导游姓名
	 */
    public String getDaoyouName() {
        return daoyouName;
    }
    /**
	 * 设置：导游姓名
	 */

    public void setDaoyouName(String daoyouName) {
        this.daoyouName = daoyouName;
    }
    /**
	 * 获取：头像
	 */
    public String getDaoyouPhoto() {
        return daoyouPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setDaoyouPhoto(String daoyouPhoto) {
        this.daoyouPhoto = daoyouPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getDaoyouPhone() {
        return daoyouPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setDaoyouPhone(String daoyouPhone) {
        this.daoyouPhone = daoyouPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getDaoyouEmail() {
        return daoyouEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setDaoyouEmail(String daoyouEmail) {
        this.daoyouEmail = daoyouEmail;
    }
    /**
	 * 获取：假删
	 */
    public Integer getDaoyouDelete() {
        return daoyouDelete;
    }
    /**
	 * 设置：假删
	 */

    public void setDaoyouDelete(Integer daoyouDelete) {
        this.daoyouDelete = daoyouDelete;
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
        return "Daoyou{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", daoyouName=" + daoyouName +
            ", daoyouPhoto=" + daoyouPhoto +
            ", sexTypes=" + sexTypes +
            ", daoyouPhone=" + daoyouPhone +
            ", daoyouEmail=" + daoyouEmail +
            ", daoyouDelete=" + daoyouDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
