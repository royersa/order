package com.javaacademy.amauryroyers.service.item;

import com.javaacademy.amauryroyers.domain.item.Item;
import com.javaacademy.amauryroyers.domain.item.ItemRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemService {
    private final ItemRepository itemRepository;

    @Inject
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item registerItem(Item item){
        return itemRepository.createItem(item);
    }
}
