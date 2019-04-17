package com.xmcc.weChatSell.service;

import com.xmcc.weChatSell.common.ResultEnums;
import com.xmcc.weChatSell.dto.OrderMasterDto;
import com.xmcc.weChatSell.dto.ProductCategoryDto;
import com.xmcc.weChatSell.dto.ProductInfoDto;
import com.xmcc.weChatSell.entity.ProductCategory;
import com.xmcc.weChatSell.entity.ProductInfo;
import com.xmcc.weChatSell.repository.ProductCategoryRepository;
import com.xmcc.weChatSell.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @作者 chenyi
 * @date 2019/4/16 15:58
 */
@Service
public class ProductInfoService {

    @Autowired
    ProductCategoryRepository categoryRepository;

    @Autowired
    ProductInfoRepository infoRepository;


    public List<ProductCategoryDto> getList() {
        List<ProductCategory> categories = categoryRepository.findAll();
        if (CollectionUtils.isEmpty(categories)){
            return null;
        }
        List<ProductCategoryDto> categoryDtoList
                = categories.stream().map(productCategory -> ProductCategoryDto.build(productCategory)).collect(Collectors.toList());

        List<Integer> typeList
                = categoryDtoList.stream().map(productCategoryDto -> productCategoryDto.getCategoryType()).collect(Collectors.toList());

        List<ProductInfo> productList = infoRepository.findAllByProductStatusAndCategoryTypeIn(ResultEnums.PRODUCT_UP.getCode(), typeList);

        List<ProductCategoryDto> list = categoryDtoList.parallelStream().map(productCategoryDto -> {
            productCategoryDto.setProductInfoDtoList(
                    productList.stream().filter(productInfo -> productInfo.getCategoryType() == productCategoryDto.getCategoryType())
                            .map(productInfo -> ProductInfoDto.build(productInfo)).collect(Collectors.toList()));
            return productCategoryDto;
        }).collect(Collectors.toList());

        return list;
    }


}
