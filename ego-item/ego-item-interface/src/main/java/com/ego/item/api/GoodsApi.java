package com.ego.item.api;

import com.ego.common.pojo.PageResult;
import com.ego.item.bo.SpuBO;
import com.ego.item.pojo.Sku;
import com.ego.item.pojo.SpuDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/goods")
public interface GoodsApi {

    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<SpuBO>> page(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "saleable") Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    );


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SpuBO spuBO);

    @GetMapping("/sku/list/{spuId}")
    public ResponseEntity<List<Sku>> querySkuListBySpuId(@PathVariable("spuId") Long spuId);

    @GetMapping("/spuDetail/{spuId}")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable("spuId") Long spuId);
}
