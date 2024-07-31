package com.procheck.distributerservice.service;

import com.procheck.distributerservice.dtos.Response.ResDistributerDTO;
import com.procheck.distributerservice.entities.Distributer;
import com.procheck.distributerservice.entities.Type;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import com.procheck.distributerservice.repository.DistributerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DistributerServiceImpl implements DistributerService {
    private DistributerRepository distributerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ResDistributerDTO> allDistributers() {
        try {
            List<Distributer> distributeurList = distributerRepository.findByIsDeletedFalse();
            return distributeurList.stream()
                    .map(distributer -> modelMapper.map(distributer, ResDistributerDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error occurred while fetching distributors: " + e);
            return List.of(); // Return an empty list if an exception occurs
        }
    }

    @Override
    public Distributer getDistributerById(UUID id) throws Exception {
        return distributerRepository.findById(id)
                .filter(distributer -> !distributer.getIsDeleted())
                .orElseThrow(() -> new Exception(
                        "Distributer with ID: " + id + " not found or is already deleted"
                ));
    }

    @Override
    public List<ResDistributerDTO> getDistributerByType(Type type) throws Exception {
        try {
            List<Distributer> distributeurList = distributerRepository.findByIsDeletedFalseAndType(type);
            return distributeurList.stream()
                    .map(distributer -> modelMapper.map(distributer, ResDistributerDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error occurred while fetching distributors: " + e.getMessage());
            throw new Exception("An error occurred while fetching distributors by type", e);
        }
    }
}