package de.maeddes.ShoppingItemRestApplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "shoppingItems", path = "v2")
public interface ItemRepository extends JpaRepository<Item,Long> {
 
    List<Item> findByName(String name);

}
