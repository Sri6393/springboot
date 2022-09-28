package com.lms.userservice.service;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import com.lms.userservice.entity.Schools;

public interface SchoolService {

	public void save(Schools schools);
	public ResponseEntity<?> update(String id, Schools schools);
}
