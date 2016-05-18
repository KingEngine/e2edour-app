package com.e2edour.app.facade.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 贴子
 * 
 * @author King
 */
public class TopicsBO implements Serializable {

	private static final long serialVersionUID = -5057825343427530276L;

	private String id;// 主键

	private String author;// 作者

	private String title;// 标题

	private int jokeSource;// 笑话来源：0:爬虫抓取;1:会员投稿

	private String jokeComeURL;// 当笑话是爬虫获取的时候,需要显示笑话的来源网站

	private int jokeType;// 笑话类型：0：文字笑话 1:图片笑话

	private String content;// 如果是文字笑话显示的是文字,如果是图片笑话则显示的是图片的名称

	private Date createDate;// 创建时间

	private int praiseCount;// 点赞数

	private String label;// 标签

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getJokeSource() {
		return jokeSource;
	}

	public void setJokeSource(int jokeSource) {
		this.jokeSource = jokeSource;
	}

	public String getJokeComeURL() {
		return jokeComeURL;
	}

	public void setJokeComeURL(String jokeComeURL) {
		this.jokeComeURL = jokeComeURL;
	}

	public int getJokeType() {
		return jokeType;
	}

	public void setJokeType(int jokeType) {
		this.jokeType = jokeType;
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

	public int getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
