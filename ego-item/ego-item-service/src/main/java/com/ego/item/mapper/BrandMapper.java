package com.ego.item.mapper;

import com.ego.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BrandMapper extends tk.mybatis.mapper.common.Mapper<Brand> {
    /**
     * 保存品牌和类别的关系
     * @param cid
     * @param bid
     */
    @Insert("insert into tb_category_brand (brand_id,category_id) values(#{bid},#{cid})")
    void insertBrandCategory(@Param("cid") Long cid, @Param(("bid")) Long bid);
}
