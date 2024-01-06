package com.pichincha.alejandrocastrillon.memorydb.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.alejandrocastrillon.memorydb.application.service.RequestService;
import com.pichincha.alejandrocastrillon.memorydb.domain.model.Request;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/token")
@AllArgsConstructor
public class RequestController {

    private final RequestService requestService;


    @PostMapping()
    public Mono<Request> saveRequest(@RequestBody Request request) {
        return requestService.saveRequest(request);
    }
    
}
