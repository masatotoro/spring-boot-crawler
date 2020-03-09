package jp.gihyo.wdpress.advance.api.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "crawler.app.info")
public class CrawlerAppInfo {

  private String appName;

  private String appVersion;

  private String timeStamp;
}
