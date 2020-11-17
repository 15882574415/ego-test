package com.ego.item.service;

import com.ego.common.pojo.PageResult;
import com.ego.item.mapper.BrandMapper;
import com.ego.item.pojo.Brand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/5/29
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Transactional(readOnly = true)
    public PageResult<Brand> page(Integer page, Integer pageSize, Boolean descending, String sortBy, String key) {
        //分页助手分页
        PageHelper.startPage(page, pageSize);

        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();


        //查询条件
        if(StringUtils.isNotBlank(key))
        {
            //添加模糊查询条件
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        //排序
        if(StringUtils.isNotBlank(sortBy))
        {
            //order by sortBy
            example.setOrderByClause(sortBy + (descending ? " desc":" asc"));
        }

        Page<Brand> pageInfo = (Page<Brand>)brandMapper.selectByExample(example);

        return new PageResult<>(pageInfo.getTotal(),pageInfo.getResult());
    }

    @Transactional
    public void save(Brand brand, List<Long> cids) {
        //保存品牌
        brandMapper.insertSelective(brand);
        //保存品牌和类别中间关系
        if(cids!=null)
        {
            for (Long cid : cids) {
                brandMapper.insertBrandCategory(cid, brand.getId());
            }
        }
    }
}
