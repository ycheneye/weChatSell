package com.xmcc.weChatSell.service;

import com.xmcc.weChatSell.common.OrderEnum;
import com.xmcc.weChatSell.common.PayEnum;
import com.xmcc.weChatSell.dto.OrderMasterDto;
import com.xmcc.weChatSell.entity.OrderDetail;
import com.xmcc.weChatSell.entity.OrderMaster;
import com.xmcc.weChatSell.repository.OrderMasterRepository;
import com.xmcc.weChatSell.utlis.BigDecimalUtil;
import com.xmcc.weChatSell.utlis.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @作者 chenyi
 * @date 2019/4/17 15:42
 */
@Service
public class OrderMasterService {

    @Autowired
    OrderDetailService detailService;

    @Autowired
    OrderMasterRepository masterRepository;

    public HashMap<String,String> createOrderMaster(OrderMasterDto masterDto) {

        //创建订单总金额为0  涉及到钱的都用 高精度计算
        BigDecimal totalPrice = new BigDecimal("0");

        String orderId = IDUtils.createIdbyUUID();//创建订单id

        List<OrderDetail> details = detailService.createOrderDetail(masterDto);
        for (OrderDetail orderDetail : details) {
            totalPrice = BigDecimalUtil.add(totalPrice, BigDecimalUtil.multi(orderDetail.getProductPrice(), orderDetail.getProductQuantity()));
            orderDetail.setOrderId(orderId);
        }
//        List<OrderDetail> detailList = details.stream().map(orderDetail ->
//        {
//            orderDetail.setOrderId(orderId);
//            totalPrice[0] = BigDecimalUtil.add(totalPrice[0], BigDecimalUtil.multi(orderDetail.getProductPrice(), orderDetail.getProductQuantity()));
//            return orderDetail;
//        }).collect(Collectors.toList());

        OrderMaster orderMaster = OrderMaster.builder().buyerAddress(masterDto.getAddress()).buyerName(masterDto.getBuyerName()).buyerOpenid(masterDto.getOpenid())
                .buyerPhone(masterDto.getPhone()).createTime(new Date()).orderAmount(totalPrice).orderId(orderId).orderStatus(OrderEnum.NEW.getCode())
                .payStatus(PayEnum.WAIT.getCode()).updateTime(null).build();

        detailService.batchInsert(details);

        masterRepository.save(orderMaster);

        HashMap<String, String> map = new HashMap<>();
        map.put("orderId", orderMaster.getOrderId());
        return map;
    }
}
