package com.javaacademy.amauryroyers.domain.item;

import com.javaacademy.amauryroyers.domain.item.database.ItemDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

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

    public Item getItem(UUID id){
        return itemDatabase.getItem(id);
    }

    public Item updateItem(Item updatedItem) {
       return itemDatabase.updateItem(updatedItem);
    }
}
