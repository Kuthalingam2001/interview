package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Interview;

@Repository
public interface InterViewRepo extends MongoRepository<Interview, String> {

	Interview findByIndate(String indate);

}
