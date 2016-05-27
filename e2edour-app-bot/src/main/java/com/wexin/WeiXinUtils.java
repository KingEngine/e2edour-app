package com.wexin;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * 微信帮助类
 *
 * @author King
 * @version 2016/5/27
 */
public class WeiXinUtils {
    /**
     * 用于和微信公众平台对接，验证消息是否来自微信公众平台
     *
     * @param token
     * @param timestamp -时间戳
     * @param nonce     -随机数
     * @param signature -微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @return
     */
    public static final boolean checkSignature(String token, String timestamp, String nonce, String signature) {
        List<String> params = new ArrayList<String>();
        params.add(token);
        params.add(timestamp);
        params.add(nonce);
        Collections.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String temp = params.get(0) + params.get(1) + params.get(2);
        return DigestUtils.shaHex(temp).equals(signature);
    }

    private static String weixinAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";

    private static HttpClient httpClient = new DefaultHttpClient();
    private static HttpGet httpget = new HttpGet(weixinAccessTokenUrl);

    public static String getAccessToken() {
        String body = null;
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("grant_type", "client_credential"));
        params.add(new BasicNameValuePair("appid", "wxc34aa411a70b47e5"));
        params.add(new BasicNameValuePair("secret", "99da049d6f1ac5bf51f63b4badd13fb6"));
        try {
            String str = EntityUtils.toString(new UrlEncodedFormEntity(params));
            httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
            HttpResponse httpresponse = httpClient.execute(httpget);
            HttpEntity entity = httpresponse.getEntity();
            body = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    public static void main(String[] args) {
        System.out.println(getAccessToken());
    }

}
