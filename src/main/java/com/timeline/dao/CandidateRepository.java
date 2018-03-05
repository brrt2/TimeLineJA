package com.timeline.dao;

import com.timeline.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate,String>{
    Candidate findById(String id);


    @Query(value = "{event.eventType:?0}")
    List<Candidate> findByEvents(String event);
}
