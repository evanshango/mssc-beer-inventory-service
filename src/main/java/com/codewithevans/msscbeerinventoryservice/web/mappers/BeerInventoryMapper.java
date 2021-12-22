package com.codewithevans.msscbeerinventoryservice.web.mappers;

import com.codewithevans.msscbeerinventoryservice.domain.BeerInventory;
import com.codewithevans.brewery.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
