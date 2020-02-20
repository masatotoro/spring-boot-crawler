package jp.gihyo.wbpress.qiita.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "item")
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QiitaItem {

	@Id
	String id;

	String title;

	String url;

	@JsonProperty("created_at")
	String createTime;

	@JsonProperty("updated_at")
	String updateTime;

}
