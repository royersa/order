package com.javaacademy.amauryroyers.domain.item;

import com.javaacademy.amauryroyers.domain.item.database.ItemDatabase;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemRepositoryTest {

    @Mock
    private ItemDatabase itemDatabase;

    @InjectMocks
    private ItemRepository itemRepository;

    @Test
    public void createItem_happyPath() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        Mockito.when(itemRepository.createItem(item)).thenReturn(item);

        Assertions.assertThat(itemRepository.createItem(item)).isEqualTo(item);
    }

    @Test
    public void getItem_givenAnItemID_thenReturnTheCorrespondingItem() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        Mockito.when(itemRepository.createItem(item)).thenReturn(item);
        Item item1 = itemRepository.createItem(item);
        Mockito.when(itemRepository.getItem(item1.getId())).thenReturn(item);

        Assertions.assertThat(itemRepository.getItem(item1.getId())).isEqualTo(item);
    }

    @Test
    public void updateItem_givenAnUpdatedItem_thenUpdateTheCorrespondingItem() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        Item item2 = item;
        item2.setPrice(new BigDecimal("299.00"));

        Mockito.when(itemRepository.createItem(item)).thenReturn(item);
        itemRepository.createItem(item);
        Mockito.when(itemRepository.updateItem(item2)).thenReturn(item2);
        itemDatabase.updateItem(item2);

        Mockito.when(itemRepository.getItem(item.getId())).thenReturn(item2);
        Assertions.assertThat(itemDatabase.getItem(item.getId())).isEqualTo(item2);
    }
}