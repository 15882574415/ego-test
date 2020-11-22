package com.ego.item.bo;

import com.ego.item.pojo.Sku;
import com.ego.item.pojo.Spu;
import com.ego.item.pojo.SpuDetail;
import lombok.Data;

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
@Data
public class SpuBO extends Spu {
    private String categoryName;
    private String brandName;

    private List<Sku> skus;
    private SpuDetail spuDetail;
}
