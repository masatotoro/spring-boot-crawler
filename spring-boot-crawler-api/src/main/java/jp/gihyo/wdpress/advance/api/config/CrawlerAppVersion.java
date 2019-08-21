package jp.gihyo.wdpress.advance.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "crawler.app.info")
public class CrawlerAppVersion {

	private String appName;

	private String appVersion;

	private String timeStamp;



}
