package com.e2edour.app.facade.bean;

import java.io.Serializable;

/**
 * Created by King on 2015/11/26.
 */
public class CheckedEaasyBO implements Serializable {
    private String id;

    private String title;//标题

    private String content;//内容

    private String author;//作者

    private String createData;//创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateData() {
        return createData;
    }

    public void setCreateData(String createData) {
        this.createData = createData;
    }
}
