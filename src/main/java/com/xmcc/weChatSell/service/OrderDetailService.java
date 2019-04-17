package com.xmcc.weChatSell.service;

import com.xmcc.weChatSell.common.ResultEnums;
import com.xmcc.weChatSell.dao.BatchDao;
import com.xmcc.weChatSell.dto.OrderDetailDto;
import com.xmcc.weChatSell.dto.OrderMasterDto;
import com.xmcc.weChatSell.entity.OrderDetail;
import com.xmcc.weChatSell.entity.ProductInfo;
import com.xmcc.weChatSell.exception.CustomException;
import com.xmcc.weChatSell.repository.ProductInfoRepository;
import com.xmcc.weChatSell.utlis.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @作者 chenyi
 * @date 2019/4/17 15:05
 */
@Service
public class OrderDetailService extends BatchDao<OrderDetail> {

    @Autowired
    ProductInfoRepository productInfoRepository;

    public List<OrderDetail> createOrderDetail(OrderMasterDto masterDto){

        @NotEmpty(message = "订单项不能为空")
        @Valid
        List<OrderDetailDto> items = masterDto.getItems();

        ArrayList<OrderDetail> itemList = new ArrayList<>();
        for (OrderDetailDto detailDto: items) {
            Optional<ProductInfo> productInfo = productInfoRepository.findById(detailDto.getProductId());
            ProductInfo info = productInfo.get();
            if (!productInfo.isPresent()){
                throw new CustomException(info.getProductName()+"不存在,请选购其他菜肴");
            }
            if (info.getProductStatus() == ResultEnums.PRODUCT_DOWN.getCode()){
                throw new CustomException(info.getProductName()+"已经下架，请选购其他菜肴");
            }

            if (info.getProductStock() < detailDto.getProductQuantity()){
                throw new CustomException(info.getProductName()+"库存不足，请选购其他菜肴");
            }


            OrderDetail detail = OrderDetail.builder().detailId(IDUtils.createIdbyUUID()).orderId(null).createTime(new Date()).productIcon(info.getProductIcon())
                    .productId(detailDto.getProductId()).productName(info.getProductName()).productPrice(info.getProductPrice())
                    .productQuantity(detailDto.getProductQuantity()).updateTime(null).build();

            itemList.add(detail);

            //改变产品库存
            info.setProductStock(info.getProductStock()-detailDto.getProductQuantity());
            productInfoRepository.save(info);

        }
        return itemList;
    }

    @Override
    @Transactional
    public void batchInsert(List<OrderDetail> list) {
        super.batchInsert(list);
    }
}
