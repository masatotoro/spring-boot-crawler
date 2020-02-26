package jp.gihyo.wbpress.advance.crawler.crawling.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.gihyo.wbpress.advance.crawler.crawling.client.HatenaClient;
import jp.gihyo.wbpress.advance.crawler.crawling.client.QiitaClient;
import jp.gihyo.wbpress.advance.crawler.crawling.domain.HatenaItem;
import jp.gihyo.wbpress.advance.crawler.crawling.domain.QiitaItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("debug")
public class DebugController {

  private final QiitaClient qiitaClient;

  private final HatenaClient HatenaClient;

  @GetMapping(value = "qiita")
  public List<QiitaItem> getQiitaItems() {
    log.info("getItems is called");
    return qiitaClient.getItems();
  }

  @GetMapping(value = "hatena")
  public List<HatenaItem> getHatenaItems() {
    return HatenaClient.getRss().getItems();
  }
}
