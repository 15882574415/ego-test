package com.ego.item.service;

//import com.ego.common.enums.ExceptionEnum;
//import com.ego.common.exception.PayException;
//import com.ego.common.pojo.CartDto;
import com.ego.common.pojo.PageResult;
import com.ego.item.bo.SpuBO;
//import com.ego.item.mapper.SkuMapper;
//import com.ego.item.mapper.SpuDetailsMapper;
//import com.ego.item.mapper.SpuMapper;
//import com.ego.item.mapper.StockMapper;
import com.ego.item.pojo.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
//import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/5/31
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@Service
public class GoodsService {
//    @Autowired
//    private SpuMapper spuMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

//    @Autowired
//    private SpuDetailsMapper spuDetailMapper;
//
//    @Autowired
//    private SkuMapper skuMapper;
//
//    @Autowired
//    private StockMapper stockMapper;
//
//    @Autowired
//    private AmqpTemplate amqpTemplate;

//    public PageResult<SpuBO> page(String key, Boolean saleable, Integer page, Integer rows) {
//        PageHelper.startPage(page, rows);
//
//        Example example = new Example(Spu.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (StringUtils.isNotBlank(key)) {
//            criteria.andLike("title","%"+key+"%").orLike("subTitle","%"+key+"%");
//        }
//        if (saleable!=null) {
//            criteria.andEqualTo("saleable", saleable);
//        }
//
//        Page<Spu> pageInfo = (Page<Spu>) spuMapper.selectByExample(example);
//
//        //将List<Spu> --> List<SpuBo>
//        List<SpuBO> spuBOList = pageInfo.stream().map(spu -> {
//            SpuBO spuBo = new SpuBO();
//            //拷贝已有属性
//            BeanUtils.copyProperties(spu, spuBo);
//
//            //查询类别名字&品牌名字
//            List<Category> categoryList = categoryService.getListByCids(Arrays.asList(spu.getCid1(),spu.getCid2(),spu.getCid3()));
//
//            List<String> names = categoryList.stream().map(category -> category.getName()).collect(Collectors.toList());
//
//            spuBo.setCategoryName(StringUtils.join(names,"/"));
//
//
//            Brand brand = brandService.getById(spu.getBrandId());
//            spuBo.setBrandName(brand.getName());
//            return spuBo;
//        }).collect(Collectors.toList());
//        return new PageResult<SpuBO>(pageInfo.getTotal(),spuBOList);
//    }

//    public void save(SpuBO spuBO) {
//        //保存spu & spudetail
//        spuBO.setSaleable(true);
//        spuBO.setValid(true);
//        spuBO.setCreateTime(new Date());
//        spuBO.setLastUpdateTime(spuBO.getCreateTime());
//
//        spuMapper.insertSelective(spuBO);
//
//        //设置关系
//        spuBO.getSpuDetail().setSpuId(spuBO.getId());
//        spuDetailMapper.insertSelective(spuBO.getSpuDetail());
//        //保存sku & stock
//        if(spuBO.getSkus()!=null)
//        {
//            spuBO.getSkus().forEach(sku -> {
//                //设置关系
//                sku.setSpuId(spuBO.getId());
//
//                sku.setCreateTime(spuBO.getCreateTime());
//                sku.setLastUpdateTime(spuBO.getCreateTime());
//
//                skuMapper.insertSelective(sku);
//
//                Stock stock = sku.getStock();
//                stock.setSkuId(sku.getId());
//                stockMapper.insertSelective(stock);
//            });
//        }
//
//        //发送消息到交换机(通知其他微服务)
//        amqpTemplate.convertAndSend("item.insert",spuBO.getId());
//    }
//
//    /**
//     * 根据spuId查询出对应skuList
//     * @param spuId
//     * @return
//     */
//    public List<Sku> querySkuListBySpuId(Long spuId) {
//        Sku sku = new Sku();
//        sku.setSpuId(spuId);
//        return skuMapper.select(sku);
//    }
//
//    public SpuDetail querySpuDetailBySpuId(Long spuId) {
//        return spuDetailMapper.selectByPrimaryKey(spuId);
//    }
//
//    public SpuBO queryGoodsById(Long spuId) {
//        SpuBO result = new SpuBO();
//        //查询spu，spuDetail ,skus
//        Spu spu =  spuMapper.selectByPrimaryKey(spuId);
//        //copy数据
//        BeanUtils.copyProperties(spu,result);
//
//        SpuDetail spuDetail = spuDetailMapper.selectByPrimaryKey(spuId);
//        result.setSpuDetail(spuDetail);
//
//        Sku sku = new Sku();
//        sku.setSpuId(spuId);
//
//        List<Sku> skus = skuMapper.select(sku);
//
//        result.setSkus(skus);
//
//        skus.forEach(s->{
//            Stock stock = stockMapper.selectByPrimaryKey(s.getId());
//            s.setStock(stock);
//        });
//
//
//        return result;
//    }
//
//    public Sku querySkuBySkuId(Long skuId) {
//        return skuMapper.selectByPrimaryKey(skuId);
//    }
//
//    @Transactional
//    public void decreaseStock(List<CartDto> cartDtos) {
//        for (CartDto cartDto : cartDtos) {
//            int count = stockMapper.decreaseStock(cartDto.getSkuId(), cartDto.getNum());
//            if (count != 1) {
//                throw new PayException(ExceptionEnum.STOCK_NOT_ENOUGH);
//            }
//        }
//    }
//
//
//    @Transactional
//    public void decreaseSeckillStock(CartDto cartDto) {
//        int count = stockMapper.decreaseSeckillStock(cartDto.getSkuId(), cartDto.getNum());
//        if (count != 1) {
//            throw new PayException(ExceptionEnum.STOCK_NOT_ENOUGH);
//        }
//    }
}
