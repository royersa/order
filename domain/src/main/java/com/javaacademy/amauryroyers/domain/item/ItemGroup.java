package com.javaacademy.amauryroyers.domain.item;

import com.javaacademy.amauryroyers.domain.item.database.ItemDatabase;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class ItemGroup {
    private UUID itemID;
    private Item item;
    private BigInteger amount;
    private LocalDate shippingDate;
    private boolean hasBeenShipped;

    @Inject
    private ItemDatabase itemDatabase;

    public ItemGroup(UUID itemID, BigInteger amount) {
        this.itemID = itemID;
        item = Item.copy(itemDatabase.getItem(this.itemID));
        this.amount = amount;
        if(itemDatabase.getItem(itemID).getAmount().intValue() < this.amount.intValue()){
            shippingDate = LocalDate.now().plusDays(7);
        }
        else{
            shippingDate = LocalDate.now().plusDays(1);
        }
        hasBeenShipped = false;
    }

    public UUID getItemID() {
        return itemID;
    }

    public void setItemID(UUID itemID) {
        this.itemID = itemID;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public BigDecimal getItemGroupTotalPrice(){
        return item.getPrice().multiply(new BigDecimal(amount));
    }

    public boolean hasBeenShipped() {
        return hasBeenShipped;
    }

    public void shipped(){
        hasBeenShipped = true;
        itemDatabase.getItem(itemID).setAmount(itemDatabase.getItem(itemID).getAmount().subtract(amount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemGroup itemGroup = (ItemGroup) o;
        return hasBeenShipped == itemGroup.hasBeenShipped &&
                Objects.equals(getItemID(), itemGroup.getItemID()) &&
                Objects.equals(getItem(), itemGroup.getItem()) &&
                Objects.equals(getAmount(), itemGroup.getAmount()) &&
                Objects.equals(getShippingDate(), itemGroup.getShippingDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getItemID(), getItem(), getAmount(), getShippingDate(), hasBeenShipped);
    }

    @Override
    public String toString() {
        return "ItemGroup{" +
                "itemID=" + itemID +
                ", amount=" + amount +
                ", shippingDate=" + shippingDate +
                ", hasBeenShipped=" + hasBeenShipped +
                '}';
    }
}
