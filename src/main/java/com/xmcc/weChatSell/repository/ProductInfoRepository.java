package com.xmcc.weChatSell.repository;

import com.xmcc.weChatSell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @作者 chenyi
 * @date 2019/4/16 16:07
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findAllByProductStatusAndCategoryTypeIn(Integer status ,List<Integer> typeList);
}
