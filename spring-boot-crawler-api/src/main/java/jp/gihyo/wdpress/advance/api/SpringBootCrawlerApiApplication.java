package jp.gihyo.wdpress.advance.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// @EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class SpringBootCrawlerApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootCrawlerApiApplication.class, args);
  }
}
