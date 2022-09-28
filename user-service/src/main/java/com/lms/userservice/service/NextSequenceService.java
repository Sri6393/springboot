package com.lms.userservice.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import com.lms.userservice.entity.CustomSequences;

@Service
public class NextSequenceService {

	@Autowired
	private MongoOperations mongo;

	public BigDecimal getNextSequence(String seqName) {
		CustomSequences counter = mongo.findAndModify(query(where("_id").is(seqName)),
			      new Update().inc("seq",1), options().returnNew(true).upsert(true),
			      CustomSequences.class);
		
		return counter.getSeq();
	}


}
