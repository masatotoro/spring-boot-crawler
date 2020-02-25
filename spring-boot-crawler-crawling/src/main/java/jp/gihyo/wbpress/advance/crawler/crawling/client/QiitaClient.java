package jp.gihyo.wbpress.advance.crawler.crawling.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import jp.gihyo.wbpress.qiita.mongo.domain.QiitaItem;

@FeignClient(
    name = "QiitaClient", //
    url = "https://qiita.com/api/v2/")
public interface QiitaClient {

  @GetMapping("/items")
  List<QiitaItem> getItems();
}
