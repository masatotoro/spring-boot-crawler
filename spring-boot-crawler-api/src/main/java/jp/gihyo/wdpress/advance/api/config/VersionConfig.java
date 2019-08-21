package jp.gihyo.wdpress.advance.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VersionConfig {
	@Bean
	public CrawlerAppVersion crawlerAppVersion() {
		return new CrawlerAppVersion();
	}

}
