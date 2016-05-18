package com.e2edour.common.security;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

public class SecurityFactory {
	private final static String md5Key="xxxx123456789oiighjkllh";
	/**
     * 方法说明:
     * <p>
     * MD5签名算法
     * @param content
     * @param key
     * @return
     * @author king
     * @since 2015年3月24日
     */
    public static String signMD5(String content) {
        String tosign = (content == null ? "" : content) + md5Key;
        try {
            return DigestUtils.md5Hex(tosign.getBytes("utf-8")).toUpperCase();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
