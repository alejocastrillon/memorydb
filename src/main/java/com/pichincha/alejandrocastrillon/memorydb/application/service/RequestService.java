package com.pichincha.alejandrocastrillon.memorydb.application.service;

import org.springframework.stereotype.Service;

import com.pichincha.alejandrocastrillon.memorydb.domain.model.Request;
import com.pichincha.alejandrocastrillon.memorydb.domain.port.in.CreateRequestUseCase;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RequestService {

    private final CreateRequestUseCase createRequest;
    
    public Mono<Request> saveRequest(Request request) {
        return createRequest.saveRequest(request);
    }

    
    
}
