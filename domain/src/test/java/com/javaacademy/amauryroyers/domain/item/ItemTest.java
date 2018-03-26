package com.javaacademy.amauryroyers.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void equals_givenTwoSimilarItems_thenCheckThatTheyAreEqual() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        Item item2 = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        item2.setId(item.getId());

        boolean result = item.equals(item2);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void toString_givenAnItem_thenReturnTheItemDataAsString() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        String result = item.toString();

        Assertions.assertThat(result).isEqualTo("Item{id=" + item.getId() + ", name='Nintendo Switch', description='The brand new hybrid console!', price=329.00, amount=10}");
    }

    @Test
    public void copy_givenAnItem_thenMakeACopyOfIt() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        Item copyItem = Item.copy(item);
        item.setPrice(new BigDecimal("299.00"));

        Assertions.assertThat(copyItem).isNotEqualTo(item);
    }
}