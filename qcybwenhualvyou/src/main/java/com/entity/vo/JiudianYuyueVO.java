package com.entity.vo;

import com.entity.JiudianYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 酒店预定
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiudian_yuyue")
public class JiudianYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 游客
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 酒店
     */

    @TableField(value = "jiudian_id")
    private Integer jiudianId;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiudian_yuyue_time")
    private Date jiudianYuyueTime;


    /**
     * 预定天数
     */

    @TableField(value = "jiudian_yuyue_number")
    private Integer jiudianYuyueNumber;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：游客
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：游客
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：酒店
	 */
    public Integer getJiudianId() {
        return jiudianId;
    }


    /**
	 * 获取：酒店
	 */

    public void setJiudianId(Integer jiudianId) {
        this.jiudianId = jiudianId;
    }
    /**
	 * 设置：预定时间
	 */
    public Date getJiudianYuyueTime() {
        return jiudianYuyueTime;
    }


    /**
	 * 获取：预定时间
	 */

    public void setJiudianYuyueTime(Date jiudianYuyueTime) {
        this.jiudianYuyueTime = jiudianYuyueTime;
    }
    /**
	 * 设置：预定天数
	 */
    public Integer getJiudianYuyueNumber() {
        return jiudianYuyueNumber;
    }


    /**
	 * 获取：预定天数
	 */

    public void setJiudianYuyueNumber(Integer jiudianYuyueNumber) {
        this.jiudianYuyueNumber = jiudianYuyueNumber;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
