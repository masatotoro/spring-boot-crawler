package jp.gihyo.wbpress.advance.crawler.crawling.service;

import java.util.stream.Collectors;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import jp.gihyo.wbpress.advance.crawler.crawling.client.HatenaClient;
import jp.gihyo.wbpress.advance.crawler.crawling.client.QiitaClient;
import jp.gihyo.wbpress.advance.crawler.crawling.domain.HatenaItem;
import jp.gihyo.wbpress.advance.crawler.crawling.domain.QiitaItem;
import jp.gihyo.wbpress.advance.lib.activemq.config.ActiveMQConfig;
import jp.gihyo.wbpress.advance.lib.activemq.domain.HatenaRequest;
import jp.gihyo.wbpress.advance.lib.activemq.domain.QiitaRequest;
import jp.gihyo.wbpress.qiita.mongo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrawlerService {

  private final HatenaClient hatenaClient;

  private final QiitaClient qiitaClient;

  private final ArticleRepository articleRepository;

  @JmsListener( //
      destination = ActiveMQConfig.QUEUE_QIITA, //
      containerFactory = "listenerContainerFactory", //
      concurrency = "1-10")
  public void receive(QiitaRequest request) {
    log.info("request=[{}]", request);
    articleRepository.saveAll(
        qiitaClient //
            .getItems()
            .stream()
            .map(QiitaItem::toArticle)
            .collect(Collectors.toList()));
  }

  @JmsListener( //
      destination = ActiveMQConfig.QUEUE_HATENA, //
      containerFactory = "listenerContainerFactory", //
      concurrency = "1-10")
  public void receive(HatenaRequest request) {
    log.info("request=[{}]", request);
    articleRepository.saveAll(
        hatenaClient
            .getRss()
            .getItems()
            .stream()
            .map(HatenaItem::toArticle)
            .collect(Collectors.toList()));
    articleRepository.saveAll(
        qiitaClient //
            .getItems()
            .stream()
            .map(QiitaItem::toArticle)
            .collect(Collectors.toList()));
  }
}
