package com.turing.util;

import com.alibaba.fastjson.JSON;
import com.e2edour.app.bot.router.TuringRes;

/**
 * 图灵返回json对象转换！
 * @author King
 * @version 2016/5/20
 */
public class TuringJsonUtil {

    public static TuringRes parse(String json){
        return  JSON.parseObject(json,TuringRes.class);
    }
}
