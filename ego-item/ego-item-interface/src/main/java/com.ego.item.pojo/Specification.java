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
@Table(name = "tb_specification")
public class Specification {

    @Id
    private Long categoryId;
    private String specifications;

}
