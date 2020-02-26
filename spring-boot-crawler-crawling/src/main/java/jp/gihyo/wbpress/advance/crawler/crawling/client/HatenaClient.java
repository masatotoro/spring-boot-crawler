package jp.gihyo.wbpress.advance.crawler.crawling.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import jp.gihyo.wbpress.advance.crawler.crawling.domain.HatenaRss;

@FeignClient(
    name = "HatenaClient", //
    url = "https://b.hatena.ne.jp/hotentry/")
public interface HatenaClient {

  @GetMapping("/it.rss")
  HatenaRss getRss();
}
