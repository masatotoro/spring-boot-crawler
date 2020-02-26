package jp.gihyo.wdpress.advance.scheduling.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jp.gihyo.wbpress.advance.lib.activemq.domain.HatenaRequest;
import jp.gihyo.wdpress.advance.scheduling.repository.SendRepository;
import lombok.RequiredArgsConstructor;

// @Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

  // private static final long INTERVAL = 900_000;
  private static final long INTERVAL = 10_000;

  private final SendRepository sendRepository;

  @Scheduled(fixedRate = INTERVAL)
  public void scheduling() {

    HatenaRequest hatenaRequest = HatenaRequest.builder().build();
    sendRepository.sendRequest(hatenaRequest);
  }
}
