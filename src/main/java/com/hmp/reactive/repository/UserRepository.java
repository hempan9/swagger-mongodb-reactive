package com.hmp.reactive.repository;

import com.hmp.reactive.model.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
