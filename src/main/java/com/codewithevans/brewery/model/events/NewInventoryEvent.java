package com.codewithevans.brewery.model.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

    private static final long serialVersionUID = 94313998454973000L;

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
