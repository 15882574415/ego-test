package com.ego.item.api;

import com.ego.item.pojo.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping("/category")
public interface CategoryApi {

    @GetMapping("/list")
    public ResponseEntity<List<Category>> list(@RequestParam(value = "pid", required = true) Long parentId) ;


    @GetMapping("/bid/{bid}")
    public ResponseEntity<List<Category>> queryCategegoryListByBid(@PathVariable(value = "bid") Long bid) ;

    @GetMapping("/cnames")
    public ResponseEntity<String> queryNamesByCids(@RequestParam("cids") List<Long> cids);
}
