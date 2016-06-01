package com.turing.util;

import com.alibaba.fastjson.JSON;
import com.e2edour.app.bot.router.News;
import com.e2edour.app.bot.router.TuringRes;

/**
 * 图灵返回json对象转换！
 *
 * @author King
 * @version 2016/5/20
 */
public class TuringJsonUtil {

    public static TuringRes parse(String json) {
        return JSON.parseObject(json, TuringRes.class);
    }

    public static void main(String[] args) {
        //String json="";
        /*TuringRes res = new TuringRes();
        res.setCode("302000");
        res.setText("test");
        ArrayList<News> newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setArticle("test");
        newsList.add(news1);
        News news2 = new News();
        news2.setArticle("test");
        newsList.add(news2);
        res.setList(newsList);
        System.out.println(JSON.toJSON(res));*/
        String json = "{\"list\":[{\"icon\":\"\",\"article\":\"test\",\"detailurl\":\"\",\"source\":\"\"},{\"icon\":\"\",\"article\":\"test\",\"detailurl\":\"\",\"source\":\"\"}],\"text\":\"test\",\"code\":\"302000\",\"url\":\"\"}";

        TuringRes result = parse(json);
        for (News news : result.getList()) {
            System.out.println(news.getArticle());
        }

    }
}
