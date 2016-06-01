package com.e2edour.app.facade.response;

import com.e2edour.common.annotation.CDataAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * @author King
 * @version 2016/6/1
 */
@XmlType
@XmlRootElement(name = "xml")
public class WeixinNewsRes extends WeixinRes {

    private String msgType;

    private int articleCount;

    private List<Item> items;

    @XmlElement(name = "MsgType")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    public String getMsgType() {
        return "news";
    }

    @XmlElement(name = "ArticleCount")
    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    @XmlElementWrapper(name="Articles")
    @XmlElement(name="item")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {

        private String title;
        private String description;
        private String picUrl;
        private String url;

        @XmlElement(name = "Description")
        @XmlJavaTypeAdapter(CDataAdapter.class)
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @XmlElement(name = "PicUrl")
        @XmlJavaTypeAdapter(CDataAdapter.class)
        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        @XmlElement(name = "Title")
        @XmlJavaTypeAdapter(CDataAdapter.class)
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @XmlElement(name = "Url")
        @XmlJavaTypeAdapter(CDataAdapter.class)
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


}
