package com.javaacademy.amauryroyers.api.item;

public class ItemDTO {
    private String name;
    private String description;
    private String price;
    private String amount;

    public static ItemDTO itemDTO(){
        return new ItemDTO();
    }

    public ItemDTO withName(String name){
        this.name = name;
        return this;
    }

    public ItemDTO withDescription(String description){
        this.description = description;
        return this;
    }

    public ItemDTO withPrice(String price){
        this.price = price;
        return this;
    }

    public ItemDTO withAmount(String amount){
        this.amount = amount;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getAmount() {
        return amount;
    }
}
