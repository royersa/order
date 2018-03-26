package com.javaacademy.amauryroyers.domain.item;

import com.javaacademy.amauryroyers.domain.item.database.ItemDatabase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemRepository {

    @Inject
    private ItemDatabase itemDatabase;

    public ItemRepository(ItemDatabase itemDatabase) {
        this.itemDatabase = itemDatabase;
    }

    public Item createItem(Item item){
        return itemDatabase.addItem(item);
    }
}
