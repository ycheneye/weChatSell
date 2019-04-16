package com.xmcc.weChatSell.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @作者 chenyi
 * @date 2019/4/16 15:13
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse<T> {
    private int code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)//返回json时忽略为null的属性
    private T data;

    public ResultResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultResponse fail(){
        return new ResultResponse(ResultEnums.FAIL.getCode(), ResultEnums.FAIL.getMsg());
    }

    public static ResultResponse fail(String msg){
        return new ResultResponse(ResultEnums.FAIL.getCode(), msg);
    }

    public static <T>ResultResponse fail(String msg,T data){
        return new ResultResponse(ResultEnums.FAIL.getCode(), msg ,data);
    }

    public static <T>ResultResponse fail(T data){
        return new ResultResponse(ResultEnums.FAIL.getCode(), ResultEnums.FAIL.getMsg() ,data);
    }

    public static ResultResponse success(){
        return new ResultResponse(ResultEnums.SUCCESS.getCode(), ResultEnums.SUCCESS.getMsg());
    }

    public static <T>ResultResponse success(T data){
        return new ResultResponse(ResultEnums.SUCCESS.getCode(), ResultEnums.SUCCESS.getMsg() ,data);
    }
}
