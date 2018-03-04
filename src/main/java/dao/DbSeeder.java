package dao;

import model.CandidateDetails;
import model.Candidate;
import model.Event;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private dao.CandidateRepository candidateRepository;

    public DbSeeder(dao.CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Event> firstEvent = new ArrayList<>();
        firstEvent.add(new Event("CV received"));

        Candidate sampleCandidate1 = new Candidate.Builder()
                .withName("Jan")
                .withSurname("Nowak")
                .withCandidateDetails(new CandidateDetails("Cracow","Poland"))
                .withEvents(firstEvent)
                .build();

        Candidate sampleCandidate2 = new Candidate.Builder()
                .withName("Jas")
                .withSurname("Fasola")
                .withCandidateDetails(new CandidateDetails("Cracow","Poland"))
                .withEvents(firstEvent)
                .build();

        Candidate sampleCandidate3 = new Candidate.Builder()
                .withName("sampleName")
                .withSurname("sampleSurname")
                .withCandidateDetails(new CandidateDetails("Cracow","Poland"))
                .withEvents(firstEvent)
                .build();



        // drop all candidates
        this.candidateRepository.deleteAll();

        //add our candidates to the database
        List<Candidate> candidates = Arrays.asList(sampleCandidate1, sampleCandidate2, sampleCandidate3);
        this.candidateRepository.save(candidates);
    }
}
