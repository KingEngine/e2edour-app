package com.e2edour.app.engine.fetcher;

import java.io.IOException;
import java.util.Date;

import com.e2edour.app.facade.TopicsFacade;
import com.e2edour.app.facade.bean.UncheckedTopicsBO;
import com.e2edour.common.bean.TopicsChannel;
import com.e2edour.common.bean.TopicsType;
import com.e2edour.common.utils.LoggerUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e2edour.app.facade.bean.TopicsBO;

/**
 * 笑话网的解析方法
 * http://xiaohua.zol.com.cn/baoxiao/
 * @author King
 *
 */
@Service("XiaoHuaFetcherEngine")
public class XiaoHuaFetcherEngine extends FetcherEngine {

	@Autowired
	private TopicsFacade topicsFacade;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void run() {
		fetcherAndParser(getUrls());
	}

	public void fetcherAndParser(String[] urls) {
		for(String url:urls){
			Document docs;
			try {
				docs = Jsoup.connect(url).get();
				Elements roots = docs.getElementsByAttributeValue("class", "article-summary");
				for (Element root : roots) {
					Element title = root.getElementsByAttributeValue("class","article-title").first().getElementsByTag("a").first();
					Element content = root.getElementsByAttributeValue("class","summary-text").first();
					UncheckedTopicsBO bo = new UncheckedTopicsBO();
					bo.setTitle(title.text().trim());
					bo.setContent(content.text().trim());
					bo.setAuthor(url);
					bo.setChannel(TopicsChannel.Fetcher.getCode());
					bo.setType(TopicsType.Text.getCode());
					bo.setCreateDate(new Date());
					topicsFacade.addUncheckedTopic(bo);
				}
			} catch (IOException e) {
				logger.error(LoggerUtil.getErrorMsg(e));
			}
			logger.info("XiaoHuaFetcherEngine:{}更新笑话成功",url);
		}
	}
}
