package com.javaacademy.amauryroyers.domain.item.database;

import com.javaacademy.amauryroyers.domain.item.Item;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class ItemDatabase {
    private List<Item> itemList;

    public ItemDatabase() {
        itemList = new ArrayList<>();
    }

    public Item addItem(Item item){
        itemList.add(item);
        return item;
    }
}
