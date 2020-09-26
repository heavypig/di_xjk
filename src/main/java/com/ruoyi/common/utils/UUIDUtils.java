package com.ruoyi.common.utils;

import java.util.UUID;

/**
 * 操作UUID工具类
 *
 * @author zhangyunqi
 * @date 2018/07/06
 */

public class UUIDUtils {

    private UUIDUtils() {
    }

    /**
     * 将UUID中的“-”去掉，返回字符串,UUID为32位
     *
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

}
