package com.timeline.controllers;

import com.timeline.dao.CandidateRepository;
import com.timeline.model.Candidate;
import com.timeline.model.CandidateDetails;
import com.timeline.model.Event;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CandidateRepository candidateRepository;

    private List<Candidate> candidates;

    @Before
    public void setUp() {
        populateCandidates();
    }

    @Test
    public void getAllCandidates_response200() throws Exception {
        //given
        given(candidateRepository.findAll()).willReturn(candidates);
        //when-then
        MvcResult result = this.mockMvc.perform(get("/candidates/all").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("sampleSurname"));
    }

    private void populateCandidates() {
        List<Event> firstEvent = new ArrayList<>();
        firstEvent.add(new Event("CV received"));

        Candidate sampleCandidate1 = new Candidate.Builder()
            .withName("Jan")
            .withSurname("Nowak")
            .withCandidateDetails(new CandidateDetails("Cracow", "Poland"))
            .withEvents(firstEvent)
            .build();

        Candidate sampleCandidate2 = new Candidate.Builder()
            .withName("Jas")
            .withSurname("Fasola")
            .withCandidateDetails(new CandidateDetails("Cracow", "Poland"))
            .withEvents(firstEvent)
            .build();

        Candidate sampleCandidate3 = new Candidate.Builder()
            .withName("sampleName")
            .withSurname("sampleSurname")
            .withCandidateDetails(new CandidateDetails("Cracow", "Poland"))
            .withEvents(firstEvent)
            .build();
        candidates = Lists.newArrayList(sampleCandidate1, sampleCandidate2, sampleCandidate3);
    }
}