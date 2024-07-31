package com.procheck.distributerservice.repository;

import com.procheck.distributerservice.entities.Distributer;
import com.procheck.distributerservice.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DistributerRepository extends JpaRepository<Distributer, UUID> {
    List<Distributer> findByIsDeletedFalseAndType(Type type);
    List<Distributer> findByIsDeletedFalse();
}