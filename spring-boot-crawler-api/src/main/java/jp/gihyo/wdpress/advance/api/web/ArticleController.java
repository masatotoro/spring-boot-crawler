package jp.gihyo.wdpress.advance.api.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jp.gihyo.wbpress.qiita.mongo.repository.ArticleRepository;
import jp.gihyo.wdpress.advance.api.web.api.ApiArticle;
import jp.gihyo.wdpress.advance.api.web.api.ArticleApi;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleController implements ArticleApi {

  private final ArticleRepository articleRepository;

  @Override
  public ResponseEntity<Page<ApiArticle>> getArticles(Pageable pageable) {
    return ResponseEntity.ok(
        ApiArticle.toAPI( //
            articleRepository.findAll(pageable), //
            pageable));
  }
}
