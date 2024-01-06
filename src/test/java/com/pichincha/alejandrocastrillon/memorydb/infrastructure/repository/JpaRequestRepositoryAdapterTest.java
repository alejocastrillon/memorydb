package com.pichincha.alejandrocastrillon.memorydb.infrastructure.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.alejandrocastrillon.util.UtilData;

import reactor.test.StepVerifier;

@SpringBootTest
class JpaRequestRepositoryAdapterTest {

    @Mock
    private JpaRequestRepository repository;

    @InjectMocks
    private JpaRequestRepositoryAdapter adapter;

    @Test
    void testSaveRequest() {
        when(repository.save(any())).thenReturn(UtilData.generaRequestEntity());
        StepVerifier.create(adapter.saveRequest(UtilData.generateRequest()))
            .assertNext(Assertions::assertNotNull)
            .verifyComplete();
    }
}
