package com.entity.model;

import com.entity.DaoyouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 导游
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DaoyouModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 导游姓名
     */
    private String daoyouName;


    /**
     * 头像
     */
    private String daoyouPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 联系方式
     */
    private String daoyouPhone;


    /**
     * 邮箱
     */
    private String daoyouEmail;


    /**
     * 假删
     */
    private Integer daoyouDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
