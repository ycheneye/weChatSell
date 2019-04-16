package com.xmcc.weChatSell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @作者 chenyi
 * @date 2019/4/16 15:00
 */

@Data
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_info")
@Entity
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
