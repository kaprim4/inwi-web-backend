package com.procheck.distributerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Distributer extends Tracing {
    @Id @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private Integer num;
    private Integer code;
    private String label;
    private Integer codeDistributer;
    private Integer codeStatus;

    @Enumerated(EnumType.STRING)
    private Type type;

    /*@JsonIgnore
    @OneToMany(mappedBy = "distributer", fetch = FetchType.LAZY)
    private List<Reception> receptions;*/
}