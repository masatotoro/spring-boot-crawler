package jp.gihyo.wdpress.advance.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

  @Bean
  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder //
        .routes()
        .route(
            r ->
                r //
                    .path("/rest/articles")
                    .uri("lb://crawler-api"))
        .build();
  }
}
