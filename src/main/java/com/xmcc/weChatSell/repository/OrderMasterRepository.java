package com.xmcc.weChatSell.repository;

import com.xmcc.weChatSell.dto.OrderMasterDetailDto;
import com.xmcc.weChatSell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @作者 chenyi
 * @date 2019/4/17 15:03
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findAllByBuyerOpenid(Pageable pageable, String openid);

    OrderMaster findByBuyerOpenidAndAndOrderId(String openid , String orderId);
}
