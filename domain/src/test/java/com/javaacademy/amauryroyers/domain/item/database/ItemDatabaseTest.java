package com.javaacademy.amauryroyers.domain.item.database;

import com.javaacademy.amauryroyers.domain.item.Item;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

public class ItemDatabaseTest {

    @Test
    public void addItem_happyPath() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        ItemDatabase itemDatabase = new ItemDatabase();

        Assertions.assertThat(itemDatabase.addItem(item)).isEqualTo(item);
    }

    @Test
    public void getItem_givenAnItemID_thenReturnTheCorrespondingItem() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        ItemDatabase itemDatabase = new ItemDatabase();
        itemDatabase.addItem(item);

        Assertions.assertThat(itemDatabase.getItem(item.getId())).isEqualTo(item);
    }

    @Test
    public void updateItem_givenAnUpdatedItem_thenUpdateTheCorrespondingItemInTheDatabase() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        Item item2 = item;
        item2.setPrice(new BigDecimal("299.00"));

        ItemDatabase itemDatabase = new ItemDatabase();
        itemDatabase.addItem(item);
        itemDatabase.updateItem(item2);

        Assertions.assertThat(itemDatabase.getItem(item.getId())).isEqualTo(item2);
    }
}