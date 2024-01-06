package com.pichincha.alejandrocastrillon.memorydb.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.alejandrocastrillon.memorydb.infrastructure.entity.RequestEntity;

@Repository
public interface JpaRequestRepository extends JpaRepository<RequestEntity, Integer>{

    
}
