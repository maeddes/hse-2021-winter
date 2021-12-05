package de.maeddes.ShoppingItemRestApplication;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(
        name = "item_id_seq",
        allocationSize = 1
    )
    // required for Spring Repository to return id
    @JsonProperty
    long id;

    private String name;
    private int quantity = 1;
    private boolean complete = false;
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss")
    private Date created = new Date();

    public Item(){}

    public Item(String name){

        this.name=name;
    }

    public Item(String name, int quantity){

        this.name=name;
        this.quantity=quantity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Date getCreated() {
        return created;
    }
    
}
