package com.wexin;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 微信帮助类
 *
 * @author King
 * @version 2016/5/27
 */
public class WeiXinUtils {

    public static String SHA1(String decript) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes("UTF-8"));
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 用于和微信公众平台对接，验证消息是否来自微信公众平台
     *
     * @param token
     * @param timestamp -时间戳
     * @param nonce     -随机数
     * @param signature -微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @return
     */

    private static final  String token="wechatapi";
    public static final boolean checkSignature(String timestamp, String nonce,String signature) {
        String[] arr = new String[]{token, timestamp, nonce};
        //排序
        Arrays.sort(arr);
        //生成字符串
        StringBuffer content = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }

        System.out.println("token" + token);
        System.out.println("timestamp" +timestamp);
        System.out.println("nonce" +nonce);
        System.out.println("shaHex" + SHA1(content.toString()));
        return SHA1(content.toString()).equals(signature);
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
