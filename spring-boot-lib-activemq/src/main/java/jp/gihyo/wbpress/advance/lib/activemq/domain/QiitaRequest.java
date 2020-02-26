package jp.gihyo.wbpress.advance.lib.activemq.domain;

import jp.gihyo.wbpress.advance.lib.activemq.domain.CrawlRequest.ServiceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class QiitaRequest {
  @Builder.Default ServiceType serviceType = ServiceType.HATENA;
}
