package jp.gihyo.wdpress.advance.api.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.gihyo.wdpress.advance.api.config.CrawlerAppVersion;

@RestController
@RequestMapping("rest")
public class AppInfoRestController {

	private final CrawlerAppVersion crawlerAppVersion;

	// private final Environment environment;

	@Autowired
	public AppInfoRestController(CrawlerAppVersion crawlerAppVersion) {
		super();
		this.crawlerAppVersion = crawlerAppVersion;
	}

	@GetMapping("version")
	public ResponseEntity<CrawlerAppVersion> getVersion() {
		return ResponseEntity.ok().body(crawlerAppVersion);
	}

	// @GetMapping("environment")


}
