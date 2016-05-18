package com.e2edour.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by King on 2015/9/30.
 */
public class LoggerUtil {

    /**
     * 打印错误日志堆栈方法
     * @param ex 异常
     * @return   错误堆栈
     */
    public static String getErrorMsg(Exception ex){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        String s = stringWriter.toString();
        return s;
    }
}
