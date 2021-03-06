package com.e2edour.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author King
 * @version 2016/6/1
 */
public class SendUtil {

    private static Logger logger = LoggerFactory.getLogger(SendUtil.class);

    /**
     * 向后台发送post请求
     * @param url
     * @param param
     * @return
     */
    public static String sendPost(String url,String param) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(50000);
            conn.setReadTimeout(50000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "token");
            conn.setRequestProperty("tag", "htc_new");

            conn.connect();

            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(param);

            out.flush();
            out.close();

            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("PostServer url {},Exception:{}",url,LoggerUtil.getErrorMsg(e));
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                logger.error("PostServer url {},IOException:{}",url,LoggerUtil.getErrorMsg(ex));
            }
        }
        return result;
    }
}
