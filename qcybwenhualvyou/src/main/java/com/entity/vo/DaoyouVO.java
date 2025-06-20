package com.entity.vo;

import com.entity.DaoyouEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 导游
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("daoyou")
public class DaoyouVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 导游姓名
     */

    @TableField(value = "daoyou_name")
    private String daoyouName;


    /**
     * 头像
     */

    @TableField(value = "daoyou_photo")
    private String daoyouPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 联系方式
     */

    @TableField(value = "daoyou_phone")
    private String daoyouPhone;


    /**
     * 邮箱
     */

    @TableField(value = "daoyou_email")
    private String daoyouEmail;


    /**
     * 假删
     */

    @TableField(value = "daoyou_delete")
    private Integer daoyouDelete;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：导游姓名
	 */
    public String getDaoyouName() {
        return daoyouName;
    }


    /**
	 * 获取：导游姓名
	 */

    public void setDaoyouName(String daoyouName) {
        this.daoyouName = daoyouName;
    }
    /**
	 * 设置：头像
	 */
    public String getDaoyouPhoto() {
        return daoyouPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setDaoyouPhoto(String daoyouPhoto) {
        this.daoyouPhoto = daoyouPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getDaoyouPhone() {
        return daoyouPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setDaoyouPhone(String daoyouPhone) {
        this.daoyouPhone = daoyouPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getDaoyouEmail() {
        return daoyouEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setDaoyouEmail(String daoyouEmail) {
        this.daoyouEmail = daoyouEmail;
    }
    /**
	 * 设置：假删
	 */
    public Integer getDaoyouDelete() {
        return daoyouDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setDaoyouDelete(Integer daoyouDelete) {
        this.daoyouDelete = daoyouDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
