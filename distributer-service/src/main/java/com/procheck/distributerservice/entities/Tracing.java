package com.procheck.distributerservice.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor @Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Tracing {
    private Boolean isActivated;
    private LocalDateTime createdAt;
    private Boolean isDeleted;
    private LocalDateTime updatedAt;
}