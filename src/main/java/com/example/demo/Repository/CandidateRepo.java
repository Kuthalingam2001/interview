package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Candidate;

@Repository
public interface CandidateRepo extends MongoRepository<Candidate, String> {


	Candidate findByEmail(String email);

	boolean existsByEmail();

	boolean existsByPhoneno();

	boolean existsByPhoneno(Long phoneno);

	boolean existsByEmail(String email);

	Object findAllByStatus(String string);

	
	int countByStatus(String string);

	//Streamable<Candidate> findByIndate(Object indate);

	boolean existsByEmailAndIdIsNot(String email, String id);

	boolean existsByPhonenoAndIdIsNot(Long phoneno, String id);


	Candidate findById(Candidate id);


}
