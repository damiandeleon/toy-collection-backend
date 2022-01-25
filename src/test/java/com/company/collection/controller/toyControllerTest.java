package com.company.collection.controller;

import com.company.collection.dao.ToyDao;
import com.company.collection.dto.Toy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(toyController.class)
public class toyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToyDao dao;

    private ObjectMapper mapper = new ObjectMapper();

    private Toy daoToy;
    private String daoToyJson;
    private List<Toy> allToys = new ArrayList<>();
    private String allToysJson;

    @Before
    public void setUp() throws Exception {

        daoToy = new Toy();
        daoToy.setId(99);
        daoToy.setToyName("He-Man");
        daoToy.setToyLine("Masters of the Universe");
        daoToy.setFaction("Good");
        daoToy.setMaxForAge("8");

        Toy daoToy3 = new Toy();
        daoToy3.setId(99);
        daoToy3.setToyName("Optimus Prime");
        daoToy3.setToyLine("Transformers");
        daoToy3.setFaction("Good");
        daoToy3.setMaxForAge("8");

        Toy daoToy2 = new Toy();
        daoToy2.setId(33);
        daoToy2.setToyName("Skeletor");
        daoToy2.setToyLine("Masters of the Universe");
        daoToy2.setFaction("Evil");
        daoToy2.setMaxForAge("8");

        allToys.add(daoToy);
        allToys.add(daoToy2);
        allToys.add(daoToy3);

        daoToyJson = mapper.writeValueAsString(daoToy);
        String dooToyJson2 = mapper.writeValueAsString(daoToy2);

        allToysJson = mapper.writeValueAsString(allToys);

    }

    @Test
    public void shouldAddToyWithPostMethod() throws Exception {

        Toy toy = new Toy();
        toy.setId(99);
        toy.setToyName("He-Man");
        toy.setToyLine("Masters of the Universe");
        toy.setFaction("Good");
        toy.setMaxForAge("8");

        String toyJson = mapper.writeValueAsString(toy);

        given(dao.save(toy)).willReturn(toy);

        mockMvc.perform(
                post("/toys")
                        .content(toyJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andExpect(content().json(daoToyJson));
    }

    @Test
    public void shouldGetAllToys() throws Exception {

        given(dao.findAll()).willReturn(allToys);

        mockMvc.perform(
                get("/toys")
        )
                .andExpect(status().isOk())
                .andExpect(content().json(allToysJson));

    }

    @Test
    public void shouldGetToyByIdWithGetMethod() throws Exception {

        given(dao.findById(99)).willReturn(java.util.Optional.ofNullable(daoToy));

        mockMvc.perform(
                get("/toys/99")
        )
                .andExpect(status().isOk())
                .andExpect(content().json(daoToyJson));

    }

    @Test
    public void shouldUpdateToyWithPutRequest() throws Exception {

        mockMvc.perform(
                put("/toys/33")
                        .content(daoToyJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());

    }

    @Test
    public void shouldDeleteToyWithDeleteRequest() throws Exception {

        mockMvc.perform(delete("/toys/2")).andExpect(status().isOk());
    }
}