package com.xmcc.weChatSell.dto;

import com.xmcc.weChatSell.entity.OrderDetail;
import com.xmcc.weChatSell.entity.OrderMaster;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @作者 chenyi
 * @date 2019/4/18 10:17
 */

@Data
public class OrderMasterDetailDto extends OrderMaster {

    @NotEmpty(message = "订单项不能为空")
    @Valid//表示需要嵌套验证
    private List<OrderDetail> orderDetailList;

    public static OrderMasterDetailDto build(OrderMaster master){
        OrderMasterDetailDto dto = new OrderMasterDetailDto();
        BeanUtils.copyProperties(master, dto);
        return dto;
    }
}
