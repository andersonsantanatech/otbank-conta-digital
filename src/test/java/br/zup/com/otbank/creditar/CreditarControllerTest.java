package br.zup.com.otbank.creditar;

import br.zup.com.otbank.Conta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.net.URI;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CreditarControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ContaRepository repository;


    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void deveCreditarUmValorNaConta() throws Exception {
        var idClient = UUID.randomUUID();
        CreditarRequest request = new CreditarRequest("123456-7", idClient.toString(), new BigDecimal("15.00"));
        repository.save(new Conta("123456-7", idClient, new BigDecimal("100.00")));

        URI uri = new URI("/api/v1/creditar");
        Gson gson = new Gson();
        String json = gson.toJson(request);

        mvc.perform(
                        put(uri).content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void deveRetornarStatusNotFound() throws Exception {
        var idClient = UUID.randomUUID();
        CreditarRequest request = new CreditarRequest("123456-0", idClient.toString(), new BigDecimal("15.00"));
        repository.save(new Conta("123456-7", idClient, new BigDecimal("100.00")));

        URI uri = new URI("/api/v1/creditar");
        Gson gson = new Gson();
        String json = gson.toJson(request);

        mvc.perform(
                        put(uri).content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void deveRetornarUnprocessableConta() throws Exception {
        var idClient = UUID.randomUUID();
        var idClient2 = UUID.randomUUID();
        CreditarRequest request = new CreditarRequest("123456-7", idClient2.toString(), new BigDecimal("15.00"));
        repository.save(new Conta("123456-7", idClient, new BigDecimal("100.00")));

        URI uri = new URI("/api/v1/creditar");
        Gson gson = new Gson();
        String json = gson.toJson(request);

        mvc.perform(
                        put(uri).content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

}