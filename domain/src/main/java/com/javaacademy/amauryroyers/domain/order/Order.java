package com.javaacademy.amauryroyers.domain.order;

import com.javaacademy.amauryroyers.domain.item.ItemGroup;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public class Order {
    private UUID orderID;
    private UUID customerID;
    private List<ItemGroup> itemGroupList;

    public Order(UUID customerID){
        orderID = UUID.randomUUID();
        this.customerID = customerID;
        itemGroupList = new ArrayList<>();
    }

    public UUID getOrderId() {
        return orderID;
    }

    public void setOrderId(UUID orderID) {
        this.orderID = orderID;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public List<ItemGroup> getItemGroupList() {
        return Collections.unmodifiableList(itemGroupList);
    }

    public void addOrderedItem(UUID itemID, BigInteger amount){
        itemGroupList.add(new ItemGroup(itemID, amount));
    }

    public BigDecimal getOrderPrice(){
        BigDecimal total = BigDecimal.ZERO;
        for (ItemGroup itemGroup : itemGroupList){
            total.add(itemGroup.getItemGroupTotalPrice());
        }
        return total;
    }

    public void shipItemGroups(){
        for(ItemGroup itemGroup : itemGroupList){
            if(!itemGroup.hasBeenShipped() && LocalDate.now().compareTo(itemGroup.getShippingDate()) >= 0){
                itemGroup.shipped();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderID, order.orderID) &&
                Objects.equals(getCustomerID(), order.getCustomerID()) &&
                Objects.equals(getItemGroupList(), order.getItemGroupList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderID, getCustomerID(), getItemGroupList());
    }

    public String report(){
        String result = "Order '" + getOrderId() + "'\nItems:\n";
        for (ItemGroup itemGroup : itemGroupList){
            result += itemGroup.getItem().getName() + "\nQuantity: " + itemGroup.getItem().getAmount().toString() + "\nTotal: " + itemGroup.getItem().getPrice() + "€\n\n";
        }
        result += "Order total: " + getOrderPrice().toString() + "€\n";
        return result;
    }
}
