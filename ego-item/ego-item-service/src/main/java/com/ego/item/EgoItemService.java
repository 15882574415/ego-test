package com.ego.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 〈〉
 *
 * @author coach tam
 * @email 327395128@qq.com
 * @create 2019/5/25
 * @since 1.0.0
 * 〈坚持灵活 灵活坚持〉
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EgoItemService {
    public static void main(String[] args) {
        SpringApplication.run(EgoItemService.class, args);
    }
}
