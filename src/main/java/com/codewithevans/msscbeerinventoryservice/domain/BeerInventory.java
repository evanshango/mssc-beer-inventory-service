package com.codewithevans.msscbeerinventoryservice.domain;

import lombok.*;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeerInventory extends BaseEntity{

    @Builder
    public BeerInventory(UUID id, Long version, Timestamp createdAt, Timestamp updatedAt, UUID beerId,
                         String upc, Integer quantityOnHand) {
        super(id, version, createdAt, updatedAt);
        this.beerId = beerId;
        this.upc = upc;
        this.quantityOnHand = quantityOnHand;
    }

    private UUID beerId;
    private String upc;
    private Integer quantityOnHand = 0;
}