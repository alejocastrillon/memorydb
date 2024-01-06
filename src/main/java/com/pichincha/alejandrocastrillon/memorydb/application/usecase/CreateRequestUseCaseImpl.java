package com.pichincha.alejandrocastrillon.memorydb.application.usecase;

import org.springframework.stereotype.Component;

import com.pichincha.alejandrocastrillon.memorydb.domain.model.Request;
import com.pichincha.alejandrocastrillon.memorydb.domain.port.in.CreateRequestUseCase;
import com.pichincha.alejandrocastrillon.memorydb.domain.port.out.RequestRepositoryPort;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CreateRequestUseCaseImpl implements CreateRequestUseCase{

    private final RequestRepositoryPort repository;

    @Override
    public Mono<Request> saveRequest(Request request) {
        return repository.saveRequest(request);
    }

    
}
