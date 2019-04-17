package com.xmcc.weChatSell.common;

import lombok.Getter;

/**
 * @作者 chenyi
 * @date 2019/4/17 11:17
 */

@Getter
public enum OrderEnum {
    NEW(0,"新建订单"),
    FINSH(1,"完成"),
    CANCEL(2,"取消");

    private int code;
    private String msg;

    OrderEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
