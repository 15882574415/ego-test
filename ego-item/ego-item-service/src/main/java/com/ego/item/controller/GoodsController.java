package com.ego.item.controller;


import com.ego.common.pojo.PageResult;
import com.ego.item.bo.SpuBO;
import com.ego.item.pojo.Sku;
import com.ego.item.pojo.SpuDetail;
import com.ego.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/5/31
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
//    page?key=&saleable=1&page=1&rows=5
    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<SpuBO>> page(
        @RequestParam(value = "key",required = false) String key,
        @RequestParam(value = "saleable") Boolean saleable,
        @RequestParam(value = "page",defaultValue = "1") Integer page,
        @RequestParam(value = "rows",defaultValue = "5") Integer rows
    )
    {
        PageResult<SpuBO> result = goodsService.page(key, saleable, page, rows);

        if(result==null)
        {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SpuBO spuBO)
    {
        goodsService.save(spuBO);

        return ResponseEntity.ok(null);
    }

    @GetMapping("/sku/list/{spuId}")
    public ResponseEntity<List<Sku>> querySkuListBySpuId(@PathVariable("spuId") Long spuId){
        List<Sku> result = goodsService.querySkuListBySpuId(spuId);

        if(result==null)
        {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/spuDetail/{spuId}")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable("spuId")Long spuId){
        SpuDetail result = goodsService.querySpuDetailBySpuId(spuId);

        if(result==null)
        {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }


    @GetMapping("/spuBo/{spuId}")
    public ResponseEntity<SpuBO> queryGoodsById(@PathVariable("spuId") Long spuId)
    {
        SpuBO result = goodsService.queryGoodsById(spuId);

        if(result==null)
        {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }


    @GetMapping("/sku/{skuId}")
    public ResponseEntity<Sku> querySkuBySkuId(@PathVariable("skuId")Long skuId)
    {
        Sku sku = goodsService.querySkuBySkuId(skuId);

        if(sku==null)
        {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sku);
    }

    /**
     * 减库存
     * @param cartDtos
     * @return
     */
//    @PostMapping("stock/decrease")
//    public ResponseEntity<Void> decreaseStock(@RequestBody List<CartDto> cartDtos){
//        goodsService.decreaseStock(cartDtos);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//
//    @PostMapping("stock/seckill/decrease")
//    public ResponseEntity<Void> decreaseSeckillStock(@RequestBody CartDto cartDTO){
//        goodsService.decreaseSeckillStock(cartDTO);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}
