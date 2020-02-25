package jp.gihyo.wbpress.advance.crawler.crawling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(
    basePackages = { //
      "jp.gihyo.wbpress.advance.crawler.crawling", //
      "jp.gihyo.wbpress.advance.lib.activemq",
      "jp.gihyo.wbpress.advance.lib.mongo"
    })
public class SpringBootCrawlerCrawlingApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootCrawlerCrawlingApplication.class, args);
  }
}
