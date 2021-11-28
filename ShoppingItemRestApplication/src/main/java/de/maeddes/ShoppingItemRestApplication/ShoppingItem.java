package de.maeddes.ShoppingItemRestApplication;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ShoppingItem {

    @Id
    @GeneratedValue
    // required for Spring Repository to return id
    @JsonProperty
    long id;

    private String itemName;
    private int quantity = 1;
    private boolean isPurchased = false;
    private Date creationDate = new Date();

    public ShoppingItem(){}

    public ShoppingItem(String name){

        this.itemName=name;
    }

    public ShoppingItem(String name, int quantity){

        this.itemName=name;
        this.quantity=quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean isPurchased) {
        this.isPurchased = isPurchased;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    
}
