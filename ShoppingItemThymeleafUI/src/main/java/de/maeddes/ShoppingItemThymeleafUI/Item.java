package de.maeddes.ShoppingItemThymeleafUI;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Item implements Serializable{

    public long id;
    public String name;
    public int quantity;
    public boolean complete;
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss")
    public Date created = new Date();

    public Item(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setCreated(Date created) {
        this.created = created;
    }


    @Override
	public String toString() {
		return "Item [complete=" + complete + ", created=" + created + ", id=" + id + ", name=" + name + ", quantity="
				+ quantity + "]";
	}

}
