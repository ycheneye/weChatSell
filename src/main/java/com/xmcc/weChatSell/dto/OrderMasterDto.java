package com.xmcc.weChatSell.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @作者 chenyi
 * @date 2019/4/17 14:05
 */

@Data
@AllArgsConstructor
public class OrderMasterDto implements Serializable {

    @NotBlank(message = "买家名称不能为空")
    @JsonProperty("name")
    private String buyerName;

    @NotBlank(message = "电话号码不能为空")
    @Length(min = 11,max = 11, message = "电话号码格式有误")
    private String phone;


    @NotBlank(message = "买家地址不能为空")
    private String address;

    @NotBlank(message = "必须输入用户的微信openid")
    private String openid;

    @NotEmpty(message = "订单项不能为空")
    @Valid//表示需要嵌套验证
    private List<OrderDetailDto> items;
}
