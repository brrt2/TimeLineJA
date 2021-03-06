package com.timeline.controllers;

import com.timeline.dao.CandidateRepository;
import com.timeline.model.Candidate;
import com.timeline.model.Event;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/candidates")
public class HomeController {
    private CandidateRepository candidateRepository;

    public HomeController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @GetMapping("/all")
    public List<Candidate> getAll(){
        List<Candidate> candidates = this.candidateRepository.findAll();

        return candidates;
    }

    @PutMapping
    public void insert(@RequestBody Candidate candidate){
        this.candidateRepository.insert(candidate);
    }

    @PostMapping
    public void update(@RequestBody Candidate candidate){
        this.candidateRepository.save(candidate);
    }


    @GetMapping("/{id}")
    public Candidate getById(@PathVariable("id") String id){
        Candidate candidate = this.candidateRepository.findById(id);
        return candidate;
    }

    @GetMapping("/events/{event}")
    public List<Candidate> getByCity(@PathVariable("event") String event){
        List<Candidate> candidates = this.candidateRepository.findByEvents(event);

        return candidates;
    }

}
