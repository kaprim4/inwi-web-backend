package com.procheck.distributerservice.web;

import com.procheck.distributerservice.entities.Type;
import com.procheck.distributerservice.service.DistributerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/distributers")
@Slf4j
public class DistributerController {

    @Autowired
    private DistributerService distributerService;

    @GetMapping("/all")
    public ResponseEntity<?> allDistributers(){
        try {
            return new ResponseEntity<>(distributerService.allDistributers(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/distributer/{id}")
    public ResponseEntity<?> distributerById(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(distributerService.getDistributerById(id), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/distributer")
    public ResponseEntity<?> distributerByType(@RequestParam(value = "type", required = false, defaultValue = "PRP") Type type){
        try {
            return new ResponseEntity<>(distributerService.getDistributerByType(type), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/distributerName/{id}")
    public ResponseEntity<?> distributerNameById(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(distributerService.getDistributerById(id).getLabel(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}