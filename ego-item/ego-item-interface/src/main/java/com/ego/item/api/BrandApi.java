package com.ego.item.api;

import com.ego.common.pojo.PageResult;
import com.ego.item.pojo.Brand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/brand")
public interface BrandApi {

    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> page(
            @RequestParam(value = "pageNo", defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "descending", defaultValue = "true") Boolean descending,
            @RequestParam(value = "sortBy") String sortBy,
            @RequestParam(value = "key") String key
    );

    @PostMapping
    public ResponseEntity<Void> save(Brand brand, @RequestParam("cids") List<Long> cids) ;


    @GetMapping("/cid/{cid}")
    public ResponseEntity<List<Brand>> queryListByCid(
            @PathVariable(value = "cid") Long cid
    );
    @GetMapping("/bid/{bid}")
    public ResponseEntity<Brand> queryBrandByBid(@PathVariable("bid") Long bid);

    /**
     * 根据品牌ids查询品牌列表
     * @param ids 品牌ids
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<Brand>> queryListByIds(@RequestParam("ids") List<Long> ids);
}
