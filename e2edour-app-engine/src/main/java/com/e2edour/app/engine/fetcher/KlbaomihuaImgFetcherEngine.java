package com.e2edour.app.engine.fetcher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;


/**
 * 快乐爆米花网的图片笑话解析方法
 * http://www.klbaomihua.com/text/index.html
 * @author King
 *
 */
@Service("KlbaomihuaImgFetcherEngine")
public class KlbaomihuaImgFetcherEngine extends FetcherEngine{

	@Autowired
	private TopicsFacade topicsFacade;
	
	private @Value("#{property[imagPath]}") String filePath;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public void run() {
		fetcherAndParser(getUrls());
	}

	@Override
	void fetcherAndParser(String[] urls) {
		for(String url:urls){
			try {
				Document docs = Jsoup.connect(url).get();
				Elements roots = docs.getElementsByAttributeValue("class", "v2-dtxt");
				for (Element root : roots) {
					Element title = root.getElementsByTag("h1").first();
					Element pTage =  root.getElementsByTag("p").first();
					//获取图片地址
					Element img = pTage.select("img").first();
					String imgPath = img.absUrl("src");
					String fileName = img.attr("src");
					String content = fileName.substring(fileName.lastIndexOf("/")+1);
					//判断图片是否存在
					UncheckedTopicsBO bo = new UncheckedTopicsBO();
					bo.setTitle(title.text());
					bo.setContent(content);
					List<UncheckedTopicsBO> bos = topicsFacade.getUncheckedTopics(bo);
					if(null==bos ||bos.size()==0){
						URL imgUrl = new URL(imgPath);
						URLConnection connection = imgUrl.openConnection();
						InputStream is = connection.getInputStream();
						File file  = new File(filePath+File.separator+content);
						FileOutputStream out = new FileOutputStream(file);
						FileCopyUtils.copy(is, out);
						bo.setCreateDate(new Date());
						bo.setAuthor(url);
						bo.setChannel(TopicsChannel.Fetcher.getCode());
						bo.setType(TopicsType.Img.getCode());
						topicsFacade.addUncheckedTopic(bo);
					}
				}
				logger.info("KlbaomihuaImgFetcherEngine:{}更新笑话成功",url);
			} catch (IOException e) {
				logger.error(LoggerUtil.getErrorMsg(e));
			}

		}
	}
}
