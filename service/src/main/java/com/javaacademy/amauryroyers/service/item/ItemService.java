package com.javaacademy.amauryroyers.service.item;

import com.javaacademy.amauryroyers.domain.item.Item;
import com.javaacademy.amauryroyers.domain.item.ItemRepository;
import com.javaacademy.amauryroyers.service.exceptions.IllegalFieldFoundException;
import com.javaacademy.amauryroyers.service.exceptions.UnknownResourceException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

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

    public Item updateItem(String id, Item updatedItem){
        assertItemIdIsNotPresent(updatedItem, IllegalFieldFoundException.CrudAction.UPDATE);
        assertItemIsPresent(itemRepository.getItem(UUID.fromString(id)));
        updatedItem.setId(UUID.fromString(id));
        return itemRepository.updateItem(updatedItem);
    }

    private void assertItemIsPresent(Item queriedItemById) {
        if (queriedItemById == null) {
            throw new UnknownResourceException("ID", Item.class.getSimpleName());
        }
    }

    private void assertItemIdIsNotPresent(Item providedItem, IllegalFieldFoundException.CrudAction action) {
        if (providedItem.getId() != null) {
            throw new IllegalFieldFoundException("ID", Item.class.getSimpleName(), action);
        }
    }
}
