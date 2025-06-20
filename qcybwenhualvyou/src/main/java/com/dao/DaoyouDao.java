package com.dao;

import com.entity.DaoyouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DaoyouView;

/**
 * 导游 Dao 接口
 *
 * @author 
 */
public interface DaoyouDao extends BaseMapper<DaoyouEntity> {

   List<DaoyouView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
