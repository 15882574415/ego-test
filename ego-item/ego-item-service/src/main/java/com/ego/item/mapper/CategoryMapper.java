package com.ego.item.mapper;

import com.ego.item.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;

@Mapper
public interface CategoryMapper extends tk.mybatis.mapper.common.Mapper<Category>, SelectByIdListMapper<Category,Long> {
}
