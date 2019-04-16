package com.xmcc.weChatSell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xmcc.weChatSell.entity.ProductCategory;
import com.xmcc.weChatSell.entity.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * @作者 chenyi
 * @date 2019/4/16 15:40
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDto {

    @JsonProperty("id")
    private String productId;

    /** 名字. */
    @JsonProperty("name")
    private String productName;

    /** 单价. */
    @JsonProperty("price")
    private BigDecimal productPrice;


    /** 描述. */
    @JsonProperty("description")
    private String productDescription;

    /** 小图. */
    @JsonProperty("icon")
    private String productIcon;


    public static ProductInfoDto build(ProductInfo productInfo){
        ProductInfoDto productInfoDto = new ProductInfoDto();
        BeanUtils.copyProperties(productInfo, productInfoDto);
        return productInfoDto;
    }
}
