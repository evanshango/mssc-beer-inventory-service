package com.codewithevans.msscbeerinventoryservice.services;

import com.codewithevans.common.events.NewInventoryEvent;
import com.codewithevans.msscbeerinventoryservice.config.JmsConfig;
import com.codewithevans.msscbeerinventoryservice.domain.BeerInventory;
import com.codewithevans.msscbeerinventoryservice.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewInventoryListener {

    private final BeerInventoryRepository inventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event) {
        log.debug("Got Inventory: " + event.toString());

        inventoryRepository.save(BeerInventory
                .builder()
                .beerId(event.getBeerDto().getId())
                .upc(event.getBeerDto().getUpc())
                .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                .build()
        );
    }
}
