package jp.gihyo.wdpress.advance.api.web.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface ArticleApi {

  @GetMapping("rest/articles")
  ResponseEntity<Page<ApiArticle>> getArticles(Pageable pageable);
}
