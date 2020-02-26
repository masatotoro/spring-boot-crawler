package jp.gihyo.wbpress.advance.crawler.crawling.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jp.gihyo.wbpress.qiita.mongo.domain.Article;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QiitaItem {
  String id;
  String title;
  String url;

  @JsonProperty("created_at")
  String createTime;

  @JsonProperty("updated_at")
  String updateTime;

  public static Article toArticle(QiitaItem qiitaItem) {
    return Article //
        .builder()
        .title(qiitaItem.getTitle())
        .url(qiitaItem.getUrl())
        .build();
  }
}
