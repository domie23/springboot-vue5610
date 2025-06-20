package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiudianCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 酒店收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiudian_collection")
public class JiudianCollectionView extends JiudianCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jiudianCollectionValue;

	//级联表 酒店信息
		/**
		* 酒店名称
		*/

		@ColumnInfo(comment="酒店名称",type="varchar(200)")
		private String jiudianName;
		/**
		* 房间类型
		*/
		@ColumnInfo(comment="房间类型",type="int(11)")
		private Integer jiudianTypes;
			/**
			* 房间类型的值
			*/
			@ColumnInfo(comment="房间类型的字典表值",type="varchar(200)")
			private String jiudianValue;
		/**
		* 价格/天
		*/
		@ColumnInfo(comment="价格/天",type="decimal(10,2)")
		private Double jiudianMoney;
		/**
		* 酒店图片
		*/

		@ColumnInfo(comment="酒店图片",type="varchar(200)")
		private String jiudianPhoto;
		/**
		* 酒店地址
		*/

		@ColumnInfo(comment="酒店地址",type="varchar(200)")
		private String jiudianAddress;
		/**
		* 热度
		*/

		@ColumnInfo(comment="热度",type="int(11)")
		private Integer jiudianClicknum;
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
		* 冻结状态
		*/
		@ColumnInfo(comment="冻结状态",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 冻结状态的值
			*/
			@ColumnInfo(comment="冻结状态的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 酒店详情
		*/

		@ColumnInfo(comment="酒店详情",type="longtext")
		private String jiudianContent;
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



	public JiudianCollectionView() {

	}

	public JiudianCollectionView(JiudianCollectionEntity jiudianCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jiudianCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJiudianCollectionValue() {
		return jiudianCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJiudianCollectionValue(String jiudianCollectionValue) {
		this.jiudianCollectionValue = jiudianCollectionValue;
	}


	//级联表的get和set 酒店信息

		/**
		* 获取： 酒店名称
		*/
		public String getJiudianName() {
			return jiudianName;
		}
		/**
		* 设置： 酒店名称
		*/
		public void setJiudianName(String jiudianName) {
			this.jiudianName = jiudianName;
		}
		/**
		* 获取： 房间类型
		*/
		public Integer getJiudianTypes() {
			return jiudianTypes;
		}
		/**
		* 设置： 房间类型
		*/
		public void setJiudianTypes(Integer jiudianTypes) {
			this.jiudianTypes = jiudianTypes;
		}


			/**
			* 获取： 房间类型的值
			*/
			public String getJiudianValue() {
				return jiudianValue;
			}
			/**
			* 设置： 房间类型的值
			*/
			public void setJiudianValue(String jiudianValue) {
				this.jiudianValue = jiudianValue;
			}

		/**
		* 获取： 价格/天
		*/
		public Double getJiudianMoney() {
			return jiudianMoney;
		}
		/**
		* 设置： 价格/天
		*/
		public void setJiudianMoney(Double jiudianMoney) {
			this.jiudianMoney = jiudianMoney;
		}

		/**
		* 获取： 酒店图片
		*/
		public String getJiudianPhoto() {
			return jiudianPhoto;
		}
		/**
		* 设置： 酒店图片
		*/
		public void setJiudianPhoto(String jiudianPhoto) {
			this.jiudianPhoto = jiudianPhoto;
		}

		/**
		* 获取： 酒店地址
		*/
		public String getJiudianAddress() {
			return jiudianAddress;
		}
		/**
		* 设置： 酒店地址
		*/
		public void setJiudianAddress(String jiudianAddress) {
			this.jiudianAddress = jiudianAddress;
		}

		/**
		* 获取： 热度
		*/
		public Integer getJiudianClicknum() {
			return jiudianClicknum;
		}
		/**
		* 设置： 热度
		*/
		public void setJiudianClicknum(Integer jiudianClicknum) {
			this.jiudianClicknum = jiudianClicknum;
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
		* 获取： 冻结状态
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 冻结状态
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 冻结状态的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 冻结状态的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 酒店详情
		*/
		public String getJiudianContent() {
			return jiudianContent;
		}
		/**
		* 设置： 酒店详情
		*/
		public void setJiudianContent(String jiudianContent) {
			this.jiudianContent = jiudianContent;
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
		return "JiudianCollectionView{" +
			", jiudianCollectionValue=" + jiudianCollectionValue +
			", jiudianName=" + jiudianName +
			", jiudianMoney=" + jiudianMoney +
			", jiudianPhoto=" + jiudianPhoto +
			", jiudianAddress=" + jiudianAddress +
			", jiudianClicknum=" + jiudianClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", jiudianContent=" + jiudianContent +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
