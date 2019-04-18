package com.xmcc.weChatSell.repository;

import com.xmcc.weChatSell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @作者 chenyi
 * @date 2019/4/18 10:34
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
