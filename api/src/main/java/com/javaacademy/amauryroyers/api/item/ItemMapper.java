package com.javaacademy.amauryroyers.api.item;

import com.javaacademy.amauryroyers.domain.item.Item;

import javax.inject.Named;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Named
public class ItemMapper {
    public ItemDTO toDTO(Item item){
        return ItemDTO.itemDTO()
                .withID(item.getId().toString())
                .withName(item.getName())
                .withDescription(item.getDescription())
                .withPrice(item.getPrice().toString())
                .withAmount(item.getAmount().toString());
    }

    public Item toDomain(ItemDTO itemDTO){
        Item item = Item.ItemBuilder.item()
                .withName(itemDTO.getName())
                .withDescription(itemDTO.getDescription())
                .withPrice(new BigDecimal(itemDTO.getPrice()))
                .withAmount(new BigInteger(itemDTO.getAmount()))
                .build();

        item.setId(UUID.fromString(itemDTO.getID()));

        return item;
    }
}
