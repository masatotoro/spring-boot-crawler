package jp.gihyo.wdpress.advance.scheduling.repository;

import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Repository;

import jp.gihyo.wbpress.advance.lib.activemq.config.ActiveMQConfig;
import jp.gihyo.wbpress.advance.lib.activemq.domain.HatenaRequest;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SendRepository {

  private final JmsOperations jmsOperations;

  public void sendRequest(HatenaRequest hatenaRequest) {
    jmsOperations.convertAndSend(
        ActiveMQConfig.QUEUE_HATENA, //
        hatenaRequest);
  }
}
