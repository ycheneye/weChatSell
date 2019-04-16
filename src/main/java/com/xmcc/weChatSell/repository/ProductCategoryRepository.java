package com.xmcc.weChatSell.repository;

import com.xmcc.weChatSell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @作者 chenyi
 * @date 2019/4/16 16:00
 */
public interface  ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {


    List<ProductCategory> findAll();
}
