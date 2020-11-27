package com.ego.search;

import com.ego.search.dao.GoodsRespository;
import com.ego.search.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchTest {

    @Autowired
    private GoodsRespository goodsRespository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testFeignClient(){
        this.elasticsearchTemplate.createIndex(Goods.class);
        this.elasticsearchTemplate.putMapping(Goods.class);
    }

}
