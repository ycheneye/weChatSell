package com.xmcc.weChatSell.utlis;

import java.math.BigDecimal;

/**
 * @作者 chenyi
 * @date 2019/4/17 14:28
 */


public class BigDecimalUtil {

    //new BigDecimal("")//只能字符串  其他的类型都需要valueOf
    public static BigDecimal add(double b1, double b2){
        BigDecimal bigDecimal = BigDecimal.valueOf(b1);
        BigDecimal bigDecima2 = BigDecimal.valueOf(b2);
        return bigDecimal.add(bigDecima2);
    }
    public static BigDecimal add(BigDecimal b1,BigDecimal b2){

        return b1.add(b2);
    }
    //相乘
    public static BigDecimal multi(BigDecimal price,Integer quantity){
        BigDecimal bigDecimal = BigDecimal.valueOf(quantity);
        return price.multiply(bigDecimal);
    }

    public static boolean equals2(BigDecimal orderAmount, BigDecimal bigDecimal) {
        return orderAmount.compareTo(bigDecimal)==0;
    }

}
