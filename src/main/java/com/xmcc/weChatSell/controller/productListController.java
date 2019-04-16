package com.xmcc.weChatSell.controller;

import com.xmcc.weChatSell.common.ResultResponse;
import com.xmcc.weChatSell.dto.ProductCategoryDto;
import com.xmcc.weChatSell.service.ProductInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @作者 chenyi
 * @date 2019/4/16 15:32
 */

@RestController
@RequestMapping("buyer/product")
@ApiOperation("商品控制器")
public class productListController {

    @Autowired
    ProductInfoService infoService;

    @RequestMapping("/list")
    @ApiOperation("查询商品列表")
    public ResultResponse findAllProduct(){

        List<ProductCategoryDto> list = infoService.getList();
        return ResultResponse.success(list);
    }
}
