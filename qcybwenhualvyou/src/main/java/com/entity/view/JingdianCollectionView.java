package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JingdianCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 旅游景点收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jingdian_collection")
public class JingdianCollectionView extends JingdianCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jingdianCollectionValue;

	//级联表 旅游景点
		/**
		* 景点编号
		*/

		@ColumnInfo(comment="景点编号",type="varchar(200)")
		private String jingdianUuidNumber;
		/**
		* 景点名称
		*/

		@ColumnInfo(comment="景点名称",type="varchar(200)")
		private String jingdianName;
		/**
		* 景点类型
		*/
		@ColumnInfo(comment="景点类型",type="int(11)")
		private Integer jingdianTypes;
			/**
			* 景点类型的值
			*/
			@ColumnInfo(comment="景点类型的字典表值",type="varchar(200)")
			private String jingdianValue;
		/**
		* 景点图片
		*/

		@ColumnInfo(comment="景点图片",type="varchar(200)")
		private String jingdianPhoto;
		/**
		* 景点地址
		*/

		@ColumnInfo(comment="景点地址",type="varchar(200)")
		private String jingdianAddress;
		/**
		* 价格/人
		*/
		@ColumnInfo(comment="价格/人",type="decimal(10,2)")
		private Double jingdianMoney;
		/**
		* 热度
		*/

		@ColumnInfo(comment="热度",type="int(11)")
		private Integer jingdianClicknum;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 日程路线
		*/

		@ColumnInfo(comment="日程路线",type="longtext")
		private String jingdianText;
		/**
		* 旅游景点详情
		*/

		@ColumnInfo(comment="旅游景点详情",type="longtext")
		private String jingdianContent;
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



	public JingdianCollectionView() {

	}

	public JingdianCollectionView(JingdianCollectionEntity jingdianCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jingdianCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJingdianCollectionValue() {
		return jingdianCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJingdianCollectionValue(String jingdianCollectionValue) {
		this.jingdianCollectionValue = jingdianCollectionValue;
	}


	//级联表的get和set 旅游景点

		/**
		* 获取： 景点编号
		*/
		public String getJingdianUuidNumber() {
			return jingdianUuidNumber;
		}
		/**
		* 设置： 景点编号
		*/
		public void setJingdianUuidNumber(String jingdianUuidNumber) {
			this.jingdianUuidNumber = jingdianUuidNumber;
		}

		/**
		* 获取： 景点名称
		*/
		public String getJingdianName() {
			return jingdianName;
		}
		/**
		* 设置： 景点名称
		*/
		public void setJingdianName(String jingdianName) {
			this.jingdianName = jingdianName;
		}
		/**
		* 获取： 景点类型
		*/
		public Integer getJingdianTypes() {
			return jingdianTypes;
		}
		/**
		* 设置： 景点类型
		*/
		public void setJingdianTypes(Integer jingdianTypes) {
			this.jingdianTypes = jingdianTypes;
		}


			/**
			* 获取： 景点类型的值
			*/
			public String getJingdianValue() {
				return jingdianValue;
			}
			/**
			* 设置： 景点类型的值
			*/
			public void setJingdianValue(String jingdianValue) {
				this.jingdianValue = jingdianValue;
			}

		/**
		* 获取： 景点图片
		*/
		public String getJingdianPhoto() {
			return jingdianPhoto;
		}
		/**
		* 设置： 景点图片
		*/
		public void setJingdianPhoto(String jingdianPhoto) {
			this.jingdianPhoto = jingdianPhoto;
		}

		/**
		* 获取： 景点地址
		*/
		public String getJingdianAddress() {
			return jingdianAddress;
		}
		/**
		* 设置： 景点地址
		*/
		public void setJingdianAddress(String jingdianAddress) {
			this.jingdianAddress = jingdianAddress;
		}

		/**
		* 获取： 价格/人
		*/
		public Double getJingdianMoney() {
			return jingdianMoney;
		}
		/**
		* 设置： 价格/人
		*/
		public void setJingdianMoney(Double jingdianMoney) {
			this.jingdianMoney = jingdianMoney;
		}

		/**
		* 获取： 热度
		*/
		public Integer getJingdianClicknum() {
			return jingdianClicknum;
		}
		/**
		* 设置： 热度
		*/
		public void setJingdianClicknum(Integer jingdianClicknum) {
			this.jingdianClicknum = jingdianClicknum;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getcaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setcaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 日程路线
		*/
		public String getJingdianText() {
			return jingdianText;
		}
		/**
		* 设置： 日程路线
		*/
		public void setJingdianText(String jingdianText) {
			this.jingdianText = jingdianText;
		}

		/**
		* 获取： 旅游景点详情
		*/
		public String getJingdianContent() {
			return jingdianContent;
		}
		/**
		* 设置： 旅游景点详情
		*/
		public void setJingdianContent(String jingdianContent) {
			this.jingdianContent = jingdianContent;
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
		return "JingdianCollectionView{" +
			", jingdianCollectionValue=" + jingdianCollectionValue +
			", jingdianUuidNumber=" + jingdianUuidNumber +
			", jingdianName=" + jingdianName +
			", jingdianPhoto=" + jingdianPhoto +
			", jingdianAddress=" + jingdianAddress +
			", jingdianMoney=" + jingdianMoney +
			", jingdianClicknum=" + jingdianClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", jingdianText=" + jingdianText +
			", jingdianContent=" + jingdianContent +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
