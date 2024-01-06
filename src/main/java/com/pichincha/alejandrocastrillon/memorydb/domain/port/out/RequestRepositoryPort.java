package com.pichincha.alejandrocastrillon.memorydb.domain.port.out;

import com.pichincha.alejandrocastrillon.memorydb.domain.model.Request;

import reactor.core.publisher.Mono;

public interface RequestRepositoryPort {

    Mono<Request> saveRequest(Request request);
    
}
