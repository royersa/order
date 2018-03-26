package com.javaacademy.amauryroyers.domain.item;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.UUID;

public class Item {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigInteger amount;

    public Item(String name, String description, BigDecimal price, BigInteger amount) {
        id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public Item setId(UUID id){
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(getId(), item.getId()) &&
                Objects.equals(getName(), item.getName()) &&
                Objects.equals(getDescription(), item.getDescription()) &&
                Objects.equals(getPrice(), item.getPrice()) &&
                Objects.equals(getAmount(), item.getAmount());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getAmount());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public static class ItemBuilder{
        private String name;
        private String description;
        private BigDecimal price;
        private BigInteger amount;

        public static ItemBuilder item(){
            return new ItemBuilder();
        }

        public ItemBuilder withName(String name){
            this.name = name;
            return this;
        }

        public ItemBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        public ItemBuilder withPrice(BigDecimal price){
            this.price = price;
            return this;
        }

        public ItemBuilder withAmount(BigInteger amount){
            this.amount = amount;
            return this;
        }

        public Item build(){
            return new Item(name, description, price, amount);
        }
    }
}
