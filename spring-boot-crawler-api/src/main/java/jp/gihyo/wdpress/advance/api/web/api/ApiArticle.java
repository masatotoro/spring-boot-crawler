package jp.gihyo.wdpress.advance.api.web.api;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jp.gihyo.wbpress.qiita.mongo.domain.Article;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonInclude(Include.NON_NULL)
public class ApiArticle {

  private static final ApiArticle INVALID = ApiArticle.builder().build();

  String title;

  String url;

  String createTime;

  public static Page<ApiArticle> toAPI(
      Page<Article> articles, //
      Pageable pageable) {

    return new PageImpl<>(
        articles //
            .stream()
            .map(ApiArticle::convert)
            .collect(Collectors.toList()),
        pageable,
        articles.getTotalElements());
  }

  private static ApiArticle convert(Article article) {

    if (article == Article.NONE) {
      return INVALID;
    }
    return ApiArticle //
        .builder()
        .title(article.getTitle())
        .url(article.getUrl())
        .build();
  }
}
