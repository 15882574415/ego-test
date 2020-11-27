package com.ego.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/5/31
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@Data
@Table(name = "tb_stock")
public class Stock {

    @Id
    private Long skuId;
    private Integer seckillStock;// 秒杀可用库存
    private Integer seckillTotal;// 已秒杀数量
    private Integer stock;// 正常库存

}
