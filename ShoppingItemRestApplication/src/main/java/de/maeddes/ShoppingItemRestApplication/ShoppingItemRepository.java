package de.maeddes.ShoppingItemRestApplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "shoppingItems", path = "v2")
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem,Long> {
 
    List<ShoppingItem> findByItemName(String itemName);

}