package com.xmcc.weChatSell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xmcc.weChatSell.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @作者 chenyi
 * @date 2019/4/16 15:35
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDto implements Serializable {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoDto> productInfoDtoList;

    public static ProductCategoryDto build(ProductCategory productCategory){
        ProductCategoryDto categoryDto = new ProductCategoryDto();
        BeanUtils.copyProperties(productCategory, categoryDto);
        return categoryDto;
    }
}
