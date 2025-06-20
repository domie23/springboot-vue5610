package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.LiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 留言板
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("liuyan")
public class LiuyanView extends LiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 游客
		/**
		* 游客姓名
		*/

		@ColumnInfo(comment="游客姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer yonghuDelete;



	public LiuyanView() {

	}

	public LiuyanView(LiuyanEntity liuyanEntity) {
		try {
			BeanUtils.copyProperties(this, liuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 游客

		/**
		* 获取： 游客姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 游客姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 假删
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "LiuyanView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
