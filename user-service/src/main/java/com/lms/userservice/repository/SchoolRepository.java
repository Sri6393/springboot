package com.lms.userservice.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.lms.userservice.entity.Schools;

public interface SchoolRepository extends MongoRepository<Schools, String> {

	Optional<Schools> findById(ObjectId objectId);

}
