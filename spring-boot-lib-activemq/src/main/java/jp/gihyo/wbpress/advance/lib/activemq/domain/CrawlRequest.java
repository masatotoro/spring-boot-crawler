package jp.gihyo.wbpress.advance.lib.activemq.domain;

// @Builder
// @NoArgsConstructor(access = AccessLevel.PRIVATE)
// @AllArgsConstructor(access = AccessLevel.PRIVATE)
// @Getter
public interface CrawlRequest {

  //  @JsonProperty("uri")
  //  URI uri;

  // ServiceType serviceType;
  enum ServiceType {
    QIITA, //
    HATENA;
  }
}
