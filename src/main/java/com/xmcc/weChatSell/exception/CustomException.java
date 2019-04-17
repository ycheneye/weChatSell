package com.xmcc.weChatSell.exception;

import com.xmcc.weChatSell.common.ResultEnums;
import lombok.Getter;

/**
 * @作者 chenyi
 * @date 2019/4/17 14:30
 */
@Getter
public class CustomException extends RuntimeException {

    private int code;


    public CustomException() {
        super();
    }

    /**
     * 默认是失败的code
     * @param message
     */
    public CustomException(String message) {
        this(ResultEnums.FAIL.getCode(),message);
    }

    /**
     * 可以传入自己需要的code
     * @param code
     * @param message
     */
    public CustomException(int code,String message) {
        super(message);
        this.code  = code;
    }
}
