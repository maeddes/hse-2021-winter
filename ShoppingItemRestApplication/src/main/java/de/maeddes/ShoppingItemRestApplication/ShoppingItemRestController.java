package de.maeddes.ShoppingItemRestApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shoppingItems")
public class ShoppingItemRestController {

    @Autowired
    ShoppingItemRepository shoppingItemRepository;

    @PostMapping(path = "/{itemName}")
    ShoppingItem addShoppingItemByName(@PathVariable String itemName){

        ShoppingItem shoppingItem = new ShoppingItem(itemName);
        shoppingItemRepository.save(shoppingItem);
        return shoppingItem;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    ShoppingItem addShoppingItem(@RequestBody ShoppingItem item){

        shoppingItemRepository.save(item);
        return item;

    }

    @GetMapping(produces = "application/json")
    List<ShoppingItem> getShoppingItems(){

        List<ShoppingItem> shoppingItems = shoppingItemRepository.findAll();
        return shoppingItems;

    }

    @GetMapping(path = "/test", produces = "application/json")
    List<ShoppingItem> getShoppingItemByName(@RequestParam("itemName") String itemName){

        List<ShoppingItem> shoppingItems = shoppingItemRepository.findByItemName(itemName);
        return shoppingItems;

    }
    
}
