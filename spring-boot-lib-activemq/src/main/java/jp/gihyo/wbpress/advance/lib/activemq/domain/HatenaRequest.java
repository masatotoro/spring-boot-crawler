package jp.gihyo.wbpress.advance.lib.activemq.domain;

import jp.gihyo.wbpress.advance.lib.activemq.domain.CrawlRequest.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class HatenaRequest {
  @Builder.Default ServiceType serviceType = ServiceType.HATENA;
}
