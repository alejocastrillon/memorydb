package com.pichincha.alejandrocastrillon.memorydb.infrastructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pichincha.alejandrocastrillon.memorydb.domain.model.Request;
import com.pichincha.alejandrocastrillon.memorydb.domain.port.out.RequestRepositoryPort;
import com.pichincha.alejandrocastrillon.memorydb.infrastructure.entity.JsonDataEntity;
import com.pichincha.alejandrocastrillon.memorydb.infrastructure.entity.RequestEntity;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class JpaRequestRepositoryAdapter implements RequestRepositoryPort {

    private final JpaRequestRepository repository;

    @Override
    public Mono<Request> saveRequest(Request request) {
        List<JsonDataEntity> data = new ArrayList<>();
        request.getData()
            .forEach((key, value) -> data.add(JsonDataEntity.builder().keySpec(key).valueSpec(value).build()));
        RequestEntity entity = RequestEntity.builder().token(request.getToken()).data(data).build();
        RequestEntity savedEntity = repository.save(entity);
        HashMap<String, String> json = new HashMap<>();
        savedEntity.getData().forEach(d -> json.put(d.getKeySpec(), d.getValueSpec()));
        return Mono.just(Request.builder().id(savedEntity.getId()).token(savedEntity.getToken()).data(json).build());
    }
    
}
