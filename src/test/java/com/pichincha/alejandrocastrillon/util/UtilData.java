package com.pichincha.alejandrocastrillon.util;

import java.util.HashMap;
import java.util.List;

import com.pichincha.alejandrocastrillon.memorydb.domain.model.Request;
import com.pichincha.alejandrocastrillon.memorydb.infrastructure.entity.JsonDataEntity;
import com.pichincha.alejandrocastrillon.memorydb.infrastructure.entity.RequestEntity;

public final class UtilData {
    
    private UtilData() {
    }

    public static Request generateRequest() {
        HashMap<String, String> json = new HashMap<>();
        json.put("uno", "1");
        return Request.builder().id(1).token("1234").data(json).build();
    }

    public static RequestEntity generaRequestEntity() {
        List<JsonDataEntity> dataEntities = List.of(
            JsonDataEntity.builder().id(1).keySpec("uno").valueSpec("1").build());
        return RequestEntity.builder().id(1).token("1234").data(dataEntities).build();
    }
}
