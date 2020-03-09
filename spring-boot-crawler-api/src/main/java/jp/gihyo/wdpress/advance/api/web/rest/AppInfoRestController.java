package jp.gihyo.wdpress.advance.api.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;

import jp.gihyo.wdpress.advance.api.domain.CrawlerAppInfo;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("rest")
@RequiredArgsConstructor
public class AppInfoRestController {

  private final CrawlerAppInfo crawlerAppVersion;

  private final DiscoveryClient discoveryClient;
  // private final Environment environment;

  @GetMapping("version")
  public ResponseEntity<CrawlerAppInfo> getVersion() {
    return ResponseEntity.ok().body(crawlerAppVersion);
  }

  @RequestMapping("/instance-info/{applicationName}")
  public List<InstanceInfo> serviceInstancesByApplicationName(
      @PathVariable String applicationName) {
    return this.discoveryClient.getInstancesById(applicationName);
  }
}
