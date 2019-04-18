package com.xmcc.weChatSell.controller;

import com.google.common.collect.Maps;
import com.xmcc.weChatSell.common.ResultResponse;
import com.xmcc.weChatSell.dto.OrderMasterDetailDto;
import com.xmcc.weChatSell.dto.OrderMasterDto;
import com.xmcc.weChatSell.entity.OrderMaster;
import com.xmcc.weChatSell.service.OrderMasterService;
import com.xmcc.weChatSell.utlis.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
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


    @GetMapping("/list")
    public ResultResponse showOrderList(@RequestParam("page")Integer page, @RequestParam("size")Integer size,@RequestParam("openid") String openid){
        PageRequest request = PageRequest.of(page, size);
        log.info("分页信息："+request.toString());
        List<OrderMaster> orderMasters =  masterService.findAll(request ,openid);
        for (OrderMaster master:
             orderMasters) {
            log.info("订单详情："+master.toString());
        }
        return ResultResponse.success(orderMasters);
    }

    @GetMapping("/detail")
    public ResultResponse showOrderDetail(@RequestParam("orderId")String orderId,@RequestParam("openid") String openid){

        OrderMasterDetailDto masterDetailDto = masterService.getMasterDetail(orderId,openid);
        return ResultResponse.success(masterDetailDto);
    }

    @PostMapping("/cancel")
    public ResultResponse canselOrder(@RequestParam("orderId")String orderId,@RequestParam("openid") String openid){
        masterService.updateOrderMaster(orderId,openid);
        return ResultResponse.success();
    }
}
