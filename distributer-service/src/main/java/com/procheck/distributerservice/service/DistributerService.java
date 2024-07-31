package com.procheck.distributerservice.service;

import com.procheck.distributerservice.dtos.Response.ResDistributerDTO;
import com.procheck.distributerservice.entities.Distributer;
import com.procheck.distributerservice.entities.Type;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface DistributerService {
    List<ResDistributerDTO> allDistributers();
    Distributer getDistributerById(UUID id) throws Exception;
    List<ResDistributerDTO> getDistributerByType(Type type) throws Exception;
}