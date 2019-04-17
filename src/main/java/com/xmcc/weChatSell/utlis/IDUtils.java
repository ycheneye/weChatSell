package com.xmcc.weChatSell.utlis;

import java.util.UUID;

/**
 * @作者 chenyi
 * @date 2019/4/17 14:27
 */
public class IDUtils {

    public static String createIdbyUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
