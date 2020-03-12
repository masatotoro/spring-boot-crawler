package jp.gihyo.wdpress.advance.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;

import jp.gihyo.wdpress.advance.api.web.api.ArticleApi;

// @LoadBalanced
@FeignClient("crawler-api")
public interface ArticleApiClient //
extends ArticleApi {}
