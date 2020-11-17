package com.ego.item.service;

import com.ego.item.mapper.CategoryMapper;
import com.ego.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/5/28
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    public List<Category> findByParentId(Long parentId) {
        Category category = new Category();
        category.setParentId(parentId);

        return  categoryMapper.select(category);
    }
}
