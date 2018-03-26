package com.javaacademy.amauryroyers.domain.item.database;

import com.javaacademy.amauryroyers.domain.item.Item;

import javax.inject.Named;
import java.util.*;

@Named
public class ItemDatabase {
    private Map<UUID, Item> itemMap;

    public ItemDatabase() {
        itemMap = new HashMap<>();
    }

    public Item addItem(Item item){
        itemMap.put(item.getId(), item);
        return item;
    }

    public Item getItem(UUID id){
        return itemMap.get(id);
    }

    public Item updateItem(Item updatedItem) {
        itemMap.put(updatedItem.getId(), updatedItem);
        return updatedItem;
    }
}
