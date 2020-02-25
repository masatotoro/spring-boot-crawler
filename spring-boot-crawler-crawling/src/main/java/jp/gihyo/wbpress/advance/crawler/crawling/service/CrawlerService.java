package jp.gihyo.wbpress.advance.crawler.crawling.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import jp.gihyo.wbpress.advance.lib.activemq.config.ActiveMQConfig;
import jp.gihyo.wbpress.advance.lib.activemq.domain.CrawlRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CrawlerService {

  @JmsListener( //
      destination = ActiveMQConfig.REQUEST_QUEUE, //
      containerFactory = "listenerContainerFactory", //
      concurrency = "1-10")
  public void receive(CrawlRequest crawlRequest) {
    //		// 1. ActiveMQから受信したリクエストを確認
    log.info("QiitaCrawlService: crawlRequest=[{}]", crawlRequest);
    // URI uri = crawlRequest.getUri();
    //		Map<String, String> queryParams = Collections.emptyMap();
    //		// 2. Qiitaの記事をクロール
    //		List<QiitaItem> qiitaItems //
    //				= restComponent.crawlItems(uri, queryParams);
    //		log.info("size of qiitaItems=[{}]", qiitaItems.size());
    //		// 3. MongoDBに記事を保存
    //		qiitaRepository.saveAll(qiitaItems);
  }
}
