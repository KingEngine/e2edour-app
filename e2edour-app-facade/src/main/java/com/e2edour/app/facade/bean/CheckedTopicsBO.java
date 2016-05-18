package com.e2edour.app.facade.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by King on 2015/11/19.
 */
public class CheckedTopicsBO implements Serializable{

    private String id;//文字笑话以W_开头，图片笑话以JPG_开头

    private String type;//笑话类型

    private String title;//标题

    private String content;//内容

    private Date createDate;//创建时间

    private String createDateStr;

    private String channel;//渠道:会员投稿：Customer,管理员：Admin,爬虫：Fetcher

    private String author;//作者

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }
}
