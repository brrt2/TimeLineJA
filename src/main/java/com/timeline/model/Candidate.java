package com.timeline.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Candidates")
public class Candidate {
    @Id
    private String id;

    private  String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String surname;
    private CandidateDetails candidateDetails;
    private List<Event> events;


    public Candidate(Builder builder) {
        name = builder.name;
        surname=builder.surname;
        candidateDetails=builder.candidateDetails;
        events = builder.events;
    }

    public Candidate() { };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public CandidateDetails getCandidateDetails() {
        return candidateDetails;
    }

    public void setCandidateDetails(CandidateDetails candidateDetails) {
        this.candidateDetails = candidateDetails;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public static class Builder {

        private String name;
        private String surname;
        private CandidateDetails candidateDetails;
        private List<Event> events;

        public Builder withName(String name){
            this.name=name;
            return this;
        }

        public Builder withSurname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder withCandidateDetails (CandidateDetails candidateDetails){
            this.candidateDetails = candidateDetails;
            return this;
        }

        public Builder withEvents(List<Event> events) {
            this.events = events;
            return this;
        }

        public Candidate build() {
            return new Candidate(this);
        }
    }
}
