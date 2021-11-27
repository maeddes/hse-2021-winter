package de.maeddes.ShoppingItemRestApplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingItemRepository extends JpaRepository<ShoppingItem,Long> {
 
    List<ShoppingItem> findByItemName(String itemName);

}
