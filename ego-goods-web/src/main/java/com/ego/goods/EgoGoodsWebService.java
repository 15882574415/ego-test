package com.ego.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/6/6
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class EgoGoodsWebService {
    public static void main(String[] args) {
        SpringApplication.run(EgoGoodsWebService.class, args);
    }
}
