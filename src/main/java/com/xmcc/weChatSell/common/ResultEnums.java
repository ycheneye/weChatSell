package com.xmcc.weChatSell.common;

import lombok.Getter;

/**
 * @作者 chenyi
 * @date 2019/4/16 15:16
 */

@Getter
public enum ResultEnums {
    SUCCESS(0,"成功"),
    FAIL(1,"失败"),
    PRODUCT_UP(0,"正常"),
    PRODUCT_DOWN(1,"商品下架");

    private int code;
    private String msg;

    ResultEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
