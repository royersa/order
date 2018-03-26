package com.javaacademy.amauryroyers.service.item;

import com.javaacademy.amauryroyers.domain.item.Item;
import com.javaacademy.amauryroyers.domain.item.ItemRepository;
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
public class ItemServiceTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void registerItem() {
        Item item = Item.ItemBuilder.item()
                .withName("Nintendo Switch")
                .withDescription("The brand new hybrid console!")
                .withPrice(new BigDecimal("329.00"))
                .withAmount(new BigInteger("10"))
                .build();

        Mockito.when(itemRepository.createItem(item)).thenReturn(item);

        Assertions.assertThat(itemService.registerItem(item)).isEqualTo(item);
    }
}