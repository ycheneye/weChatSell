package com.xmcc.weChatSell.controller;

import com.google.common.collect.Maps;
import com.xmcc.weChatSell.common.ResultResponse;
import com.xmcc.weChatSell.dto.OrderMasterDto;
import com.xmcc.weChatSell.service.OrderMasterService;
import com.xmcc.weChatSell.utlis.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @作者 chenyi
 * @date 2019/4/17 14:17
 */

@RestController
@RequestMapping("buyer/order")
@Slf4j
public class OrderController {

    @Autowired
    OrderMasterService masterService;

    @RequestMapping("/create")
    public ResultResponse generateOrder(@Valid OrderMasterDto masterDto, BindingResult bindingResult){

        Map<String,String> map = Maps.newHashMap();
        if (bindingResult.hasErrors()){
            List<String> errList = bindingResult.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
            map.put("参数校验错误", JsonUtil.object2string(errList));
            return ResultResponse.fail(map);
        }
        map = masterService.createOrderMaster(masterDto);
        return ResultResponse.success(map);
    }
}
