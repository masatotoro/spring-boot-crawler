package jp.gihyo.wbpress.advance.crawler.crawling.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jp.gihyo.wbpress.qiita.mongo.domain.Article;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "item")
public class HatenaItem {

  @XmlElement(
      name = "title", //
      namespace = "http://purl.org/rss/1.0/")
  String title;

  @XmlElement(
      name = "link", //
      namespace = "http://purl.org/rss/1.0/")
  String link;

  public static Article toArticle(HatenaItem hatenaItem) {
    return Article //
        .builder()
        .title(hatenaItem.getTitle())
        .url(hatenaItem.getLink())
        .build();
  }
}
