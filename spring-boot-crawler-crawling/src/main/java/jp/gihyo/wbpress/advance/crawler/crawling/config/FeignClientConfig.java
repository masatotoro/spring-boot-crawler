package jp.gihyo.wbpress.advance.crawler.crawling.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Client;
import feign.httpclient.ApacheHttpClient;

@Configuration
public class FeignClientConfig {

  @Bean
  public Client feignClient(CloseableHttpClient httpClient) {
    return new ApacheHttpClient(httpClient);
  }

  @Bean
  public CloseableHttpClient httpClient() {
    HttpClientBuilder httpClientBuilder = HttpClients.custom();
    String host = System.getenv("proxyHost");
    String port = System.getenv("proxyPort");
    if (StringUtils.isNotEmpty(host) && StringUtils.isNotEmpty(port)) {
      HttpHost proxy = new HttpHost(host, Integer.parseInt(port));
      httpClientBuilder.setProxy(proxy);
    }
    return httpClientBuilder.build();
  }
}
