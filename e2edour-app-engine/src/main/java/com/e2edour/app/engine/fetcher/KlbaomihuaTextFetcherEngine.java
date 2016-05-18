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
 * 快乐爆米花网的文字笑话解析方法
 * http://www.klbaomihua.com/text/index.html
 * @author King
 *
 */
@Service("KlbaomihuaTextFetcherEngine")
public class KlbaomihuaTextFetcherEngine extends FetcherEngine {

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
				Elements roots = docs.getElementsByAttributeValue("class", "v2-dtxt");
				for (Element root : roots) {
					Element title = root.getElementsByTag("h1").first();
					Elements contentEls =  root.getElementsByTag("p");
					StringBuffer buffer = new StringBuffer();
					for(int i=0;i<contentEls.size()-1;i++){
						buffer.append(contentEls.get(i).toString());
					}
					UncheckedTopicsBO bo = new UncheckedTopicsBO();
					bo.setTitle(title.text().trim());
					bo.setContent(buffer.toString());
					bo.setAuthor(url);
					bo.setCreateDate(new Date());
					bo.setType(TopicsType.Text.getCode());
					bo.setChannel(TopicsChannel.Fetcher.getCode());
					topicsFacade.addUncheckedTopic(bo);
				}
			} catch (IOException e) {
				logger.error(LoggerUtil.getErrorMsg(e));
			}
			logger.info("KlbaomihuaTextFetcherEngine:{}更新笑话成功",url);
		}
	}
}
