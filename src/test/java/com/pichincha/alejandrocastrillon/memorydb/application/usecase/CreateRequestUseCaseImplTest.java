package com.pichincha.alejandrocastrillon.memorydb.application.usecase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.alejandrocastrillon.memorydb.domain.port.out.RequestRepositoryPort;
import com.pichincha.alejandrocastrillon.util.UtilData;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class CreateRequestUseCaseImplTest {

    @Mock
    private RequestRepositoryPort repositoryPort;

    @InjectMocks
    private CreateRequestUseCaseImpl requestUseCase;

    @Test
    void testSaveRequest() {
        when(repositoryPort.saveRequest(any())).thenReturn(Mono.just(UtilData.generateRequest()));
        StepVerifier.create(requestUseCase.saveRequest(UtilData.generateRequest()))
            .assertNext(Assertions::assertNotNull).verifyComplete();
    }
}
