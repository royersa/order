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
}