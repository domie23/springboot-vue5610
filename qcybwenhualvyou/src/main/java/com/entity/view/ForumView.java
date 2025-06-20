package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ForumEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 论坛
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 帖子状态的值
	*/
	@ColumnInfo(comment="帖子状态的字典表值",type="varchar(200)")
	private String forumStateValue;

	//级联表 导游
		/**
		* 导游姓名
		*/

		@ColumnInfo(comment="导游姓名",type="varchar(200)")
		private String daoyouName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String daoyouPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String daoyouPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String daoyouEmail;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer daoyouDelete;
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
	//级联表 管理员
		/**
		* 用户名
		*/
		@ColumnInfo(comment="用户名",type="varchar(100)")
		private String uusername;
		/**
		* 密码
		*/
		@ColumnInfo(comment="密码",type="varchar(100)")
		private String upassword;
		/**
		* 角色
		*/
		@ColumnInfo(comment="角色",type="varchar(100)")
		private String urole;
		/**
		* 新增时间
		*/
		@ColumnInfo(comment="新增时间",type="timestamp")
		private Date uaddtime;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public ForumView() {

	}

	public ForumView(ForumEntity forumEntity) {
		try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 帖子状态的值
	*/
	public String getForumStateValue() {
		return forumStateValue;
	}
	/**
	* 设置： 帖子状态的值
	*/
	public void setForumStateValue(String forumStateValue) {
		this.forumStateValue = forumStateValue;
	}


	//级联表的get和set 导游

		/**
		* 获取： 导游姓名
		*/
		public String getDaoyouName() {
			return daoyouName;
		}
		/**
		* 设置： 导游姓名
		*/
		public void setDaoyouName(String daoyouName) {
			this.daoyouName = daoyouName;
		}

		/**
		* 获取： 头像
		*/
		public String getDaoyouPhoto() {
			return daoyouPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setDaoyouPhoto(String daoyouPhoto) {
			this.daoyouPhoto = daoyouPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getDaoyouPhone() {
			return daoyouPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setDaoyouPhone(String daoyouPhone) {
			this.daoyouPhone = daoyouPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getDaoyouEmail() {
			return daoyouEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setDaoyouEmail(String daoyouEmail) {
			this.daoyouEmail = daoyouEmail;
		}

		/**
		* 获取： 假删
		*/
		public Integer getDaoyouDelete() {
			return daoyouDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setDaoyouDelete(Integer daoyouDelete) {
			this.daoyouDelete = daoyouDelete;
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
	//级联表的get和set 管理员
		/**
		* 获取： 用户名
		*/
		public String getUusername() {
			return uusername;
		}
		/**
		* 设置： 用户名
		*/
		public void setUusername(String uusername) {
			this.uusername = uusername;
		}
		/**
		* 获取： 密码
		*/
		public String getUpassword() {
			return upassword;
		}
		/**
		* 设置： 密码
		*/
		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}
		/**
		* 获取： 角色
		*/
		public String getUrole() {
			return urole;
		}
		/**
		* 设置： 角色
		*/
		public void setUrole(String urole) {
			this.urole = urole;
		}
		/**
		* 获取： 新增时间
		*/
		public Date getUaddtime() {
			return uaddtime;
		}
		/**
		* 设置： 新增时间
		*/
		public void setUaddtime(Date uaddtime) {
			this.uaddtime = uaddtime;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "ForumView{" +
			", forumStateValue=" + forumStateValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			", daoyouName=" + daoyouName +
			", daoyouPhoto=" + daoyouPhoto +
			", daoyouPhone=" + daoyouPhone +
			", daoyouEmail=" + daoyouEmail +
			", daoyouDelete=" + daoyouDelete +
			"} " + super.toString();
	}
}
