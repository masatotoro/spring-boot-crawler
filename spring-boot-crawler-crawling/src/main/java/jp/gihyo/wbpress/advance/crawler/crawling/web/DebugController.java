package jp.gihyo.wbpress.advance.crawler.crawling.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.gihyo.wbpress.advance.crawler.crawling.client.QiitaClient;
import jp.gihyo.wbpress.qiita.mongo.domain.QiitaItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("qiita")
public class DebugController {

  private final QiitaClient qiitaClient;

  @GetMapping(value = "items")
  public List<QiitaItem> getItems() {
    log.info("getItems is called");
    return qiitaClient.getItems();
  }
}
