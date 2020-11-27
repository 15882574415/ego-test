package com.ego.item.controller;

import com.ego.item.pojo.Category;
import com.ego.item.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/5/28
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResponseEntity<List<Category>> list(@RequestParam(value = "pid",required = true) Long parentId) {
        List<Category> result = categoryService.findByParentId(parentId);
        if (result == null || result.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/cnames")
    public ResponseEntity<String> queryNamesByCids(@RequestParam("cids") List<Long> cids){
        List<Category> result = categoryService.getListByCids(cids);
        List<String> cnameList = result.stream().map(category -> category.getName()).collect(Collectors.toList());
        if (result == null || result.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(StringUtils.join(cnameList,","));
    }


}
