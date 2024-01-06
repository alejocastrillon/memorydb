package com.pichincha.alejandrocastrillon.memorydb.domain.port.in;

import com.pichincha.alejandrocastrillon.memorydb.domain.model.Request;

import reactor.core.publisher.Mono;

public interface CreateRequestUseCase {
    
    Mono<Request> saveRequest(Request request);
    
}
