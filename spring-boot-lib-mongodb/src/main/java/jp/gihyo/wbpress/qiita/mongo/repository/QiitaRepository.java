package jp.gihyo.wbpress.qiita.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import jp.gihyo.wbpress.qiita.mongo.domain.QiitaItem;

@Repository
public interface QiitaRepository //
		extends MongoRepository<QiitaItem, String> {

}
