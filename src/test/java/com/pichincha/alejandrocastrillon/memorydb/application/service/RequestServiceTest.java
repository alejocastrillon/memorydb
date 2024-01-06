package com.pichincha.alejandrocastrillon.memorydb.application.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.alejandrocastrillon.memorydb.domain.port.in.CreateRequestUseCase;
import com.pichincha.alejandrocastrillon.util.UtilData;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class RequestServiceTest {

    @Mock
    private CreateRequestUseCase createRequest;

    @InjectMocks
    private RequestService requestService;

    @Test
    void testSaveRequest() {
        when(createRequest.saveRequest(any())).thenReturn(Mono.just(UtilData.generateRequest()));
        StepVerifier.create(requestService.saveRequest(UtilData.generateRequest()))
            .assertNext(Assertions::assertNotNull).verifyComplete();

    }
}
