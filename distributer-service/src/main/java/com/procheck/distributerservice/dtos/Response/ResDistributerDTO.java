package com.procheck.distributerservice.dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResDistributerDTO {
    private UUID id;
    private String label;
    private String type;
}
