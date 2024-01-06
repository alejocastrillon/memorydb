package com.pichincha.alejandrocastrillon.memorydb.domain.model;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Request {
    
    private int id;

    private String token;

    private HashMap<String, String> data;

}
