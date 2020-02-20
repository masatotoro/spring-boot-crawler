package jp.gihyo.wbpress.advance.lib.activemq.domain;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
// @Setter
// @ToString
public class CrawlRequest {

  @JsonProperty("uri")
  URI uri;
}
