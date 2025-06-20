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
 * 酒店预定
 *
 * @author 
 * @email
 */
@TableName("jiudian_yuyue")
public class JiudianYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiudianYuyueEntity() {

	}

	public JiudianYuyueEntity(T t) {
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
     * 游客
     */
    @ColumnInfo(comment="游客",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 酒店
     */
    @ColumnInfo(comment="酒店",type="int(11)")
    @TableField(value = "jiudian_id")

    private Integer jiudianId;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预定时间",type="timestamp")
    @TableField(value = "jiudian_yuyue_time")

    private Date jiudianYuyueTime;


    /**
     * 预定天数
     */
    @ColumnInfo(comment="预定天数",type="int(11)")
    @TableField(value = "jiudian_yuyue_number")

    private Integer jiudianYuyueNumber;


    /**
     * 创建时间  listShow
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
	 * 获取：游客
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：游客
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：酒店
	 */
    public Integer getJiudianId() {
        return jiudianId;
    }
    /**
	 * 设置：酒店
	 */

    public void setJiudianId(Integer jiudianId) {
        this.jiudianId = jiudianId;
    }
    /**
	 * 获取：预定时间
	 */
    public Date getJiudianYuyueTime() {
        return jiudianYuyueTime;
    }
    /**
	 * 设置：预定时间
	 */

    public void setJiudianYuyueTime(Date jiudianYuyueTime) {
        this.jiudianYuyueTime = jiudianYuyueTime;
    }
    /**
	 * 获取：预定天数
	 */
    public Integer getJiudianYuyueNumber() {
        return jiudianYuyueNumber;
    }
    /**
	 * 设置：预定天数
	 */

    public void setJiudianYuyueNumber(Integer jiudianYuyueNumber) {
        this.jiudianYuyueNumber = jiudianYuyueNumber;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "JiudianYuyue{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", jiudianId=" + jiudianId +
            ", jiudianYuyueTime=" + DateUtil.convertString(jiudianYuyueTime,"yyyy-MM-dd") +
            ", jiudianYuyueNumber=" + jiudianYuyueNumber +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
