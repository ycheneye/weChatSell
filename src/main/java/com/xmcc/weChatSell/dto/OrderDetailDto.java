package com.xmcc.weChatSell.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @作者 chenyi
 * @date 2019/4/17 14:01
 */

@Data
public class OrderDetailDto {

    @NotBlank(message = "商品id不能为空")
    private String productId;

    @NotNull(message = "商品数量不能为空")
    @Min(value = 1,message = "商品数量至少为1")
    private Integer productQuantity;
}
