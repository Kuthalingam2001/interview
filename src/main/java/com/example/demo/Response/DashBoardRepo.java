package com.example.demo.Response;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.DashBoard;

@Repository
public interface DashBoardRepo extends MongoRepository<DashBoard, String>{

	

	
}
