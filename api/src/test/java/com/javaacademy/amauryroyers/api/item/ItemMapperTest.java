package com.javaacademy.amauryroyers.api.item;

import com.javaacademy.amauryroyers.domain.item.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

public class ItemMapperTest {

    private ItemMapper itemMapper;

    @Before
    public void instantiateMapper(){
        itemMapper = new ItemMapper();
    }

    @Test
    public void toDTO_givenAnItem_thenMapAllFieldsToItemDTO() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        ItemDTO itemDTO = itemMapper.toDTO(item);

        Assertions.assertThat(itemDTO.getName()).isEqualTo(item.getName());
        Assertions.assertThat(itemDTO.getDescription()).isEqualTo(item.getDescription());
        Assertions.assertThat(itemDTO.getPrice()).isEqualTo(item.getPrice().toString());
        Assertions.assertThat(itemDTO.getAmount()).isEqualTo(item.getAmount().toString());
    }

    @Test
    public void toDomain_givenAnItemDTO_thenMapAllFieldsToItem() {
        ItemDTO itemDTO = ItemDTO.itemDTO()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice("329.00")
                .withAmount("10");

        Item item = itemMapper.toDomain(itemDTO);

        Assertions.assertThat(item.getName()).isEqualTo(itemDTO.getName());
        Assertions.assertThat(item.getDescription()).isEqualTo(itemDTO.getDescription());
        Assertions.assertThat(item.getPrice()).isEqualTo(new BigDecimal(item.getPrice().toString()));
        Assertions.assertThat(item.getAmount()).isEqualTo(new BigInteger(item.getAmount().toString()));
    }
}