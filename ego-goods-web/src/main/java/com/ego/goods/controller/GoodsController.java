package com.ego.goods.controller;

import com.ego.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/6/6
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@Controller
@RequestMapping("/item")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @GetMapping("/{id}.html")
    public String item(@PathVariable("id") Long id, Model model) {
        Map<String,Object> modelMap = goodsService.loadModel(id);
        model.addAllAttributes(modelMap);
        //异步生成静态页面
//        goodsService.buildStaticHmtl(modelMap,id);
        return "item";
    }
}
