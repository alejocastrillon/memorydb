package com.pichincha.alejandrocastrillon.memorydb.infrastructure.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.pichincha.alejandrocastrillon.memorydb.application.service.RequestService;
import com.pichincha.alejandrocastrillon.util.UtilData;

import reactor.core.publisher.Mono;

@WebFluxTest(controllers = RequestController.class)
class RequestControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private RequestService service;

    @Test
    void givenValidInfoWhenSaveRequestThenReturnRequestInfo() {
        when(service.saveRequest(any())).thenReturn(Mono.just(UtilData.generateRequest()));
        client.post().uri("/v1/token")
            .bodyValue(UtilData.generateRequest())
            .accept(MediaType.APPLICATION_JSON)
            .exchange().expectStatus().isOk();
    }
}
