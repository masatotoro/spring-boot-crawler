package jp.gihyo.wdpress.advance.scheduling.service;

import java.net.URI;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jp.gihyo.wbpress.advance.lib.activemq.domain.CrawlRequest;
import jp.gihyo.wdpress.advance.scheduling.repository.SendRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

  // private static final long INTERVAL = 900_000;
  private static final long INTERVAL = 10_000;

  private final SendRepository sendRepository;

  @Scheduled(fixedRate = INTERVAL)
  public void scheduling() {

    CrawlRequest crawlRequest =
        CrawlRequest //
            .builder()
            .uri(URI.create("https://qiita.com/api/v2/items"))
            .build();
    log.info("crawlRequest=[{}]", crawlRequest);
    sendRepository.sendRequest(crawlRequest);
  }
}
