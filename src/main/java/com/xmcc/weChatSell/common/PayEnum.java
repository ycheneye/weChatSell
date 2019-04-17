package com.xmcc.weChatSell.common;

import lombok.Getter;

/**
 * @作者 chenyi
 * @date 2019/4/17 11:20
 */

@Getter
public enum  PayEnum {
    WAIT(0,"等待支付"),
    FINSH(1,"支付完成"),
    FAIL(2,"支付失败");
    private int code;
    private String msg;

    PayEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
