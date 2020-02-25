package jp.gihyo.wbpress.advance.crawler.crawling.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

  //    @Bean
  //    public QiitaClient qiitaClient(CloseableHttpClient httpclient) {
  //      return Feign //
  //          .builder()
  //          .client(new AbstractHttpClient(httpclient))
  //          .target(QiitaClient.class, "https://qiita.com/api/v2/");
  //    }

  //  @Bean
  //  RestTemplate restTemplate() {
  //    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
  //    final String proxyHost = "proxy.osk.sony.co.jp"; // プロキシホスト
  //    final int proxyPort = 10080; // プロキシポート番号
  //    factory.setProxy(new Proxy(Type.SOCKS, new InetSocketAddress(proxyHost, proxyPort)));
  //    return new RestTemplate(factory);
  //  }

  //  @Bean
  //  public CloseableHttpClient httpclient() {
  //
  //    HttpHost proxy = new HttpHost("proxy.osk.sony.co.jp", 10080);
  //    // CredentialsProvider credsProvider = new BasicCredentialsProvider();
  //
  //    RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
  //    CloseableHttpClient httpclient =
  // HttpClients.custom().setDefaultRequestConfig(config).build();
  //    return httpclient;
  //  }
}
