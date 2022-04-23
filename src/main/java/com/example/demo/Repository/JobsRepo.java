package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Job;

@Repository
public interface JobsRepo extends MongoRepository<Job, String>{



}
