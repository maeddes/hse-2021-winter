package de.maeddes.ShoppingItemRestApplication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("shoppingItems")
public class ShoppingItemRestController {

    @Autowired
    ShoppingItemRepository shoppingItemRepository;

    @Operation(summary = "Only a hack, please ignore")
    @PostMapping(path = "/{itemName}")
    ShoppingItem createShoppingItemByName(@PathVariable String itemName) {

        ShoppingItem shoppingItem = new ShoppingItem(itemName);
        shoppingItemRepository.save(shoppingItem);
        return shoppingItem;

    }

    @Operation(summary = "Create a new shopping item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item created", content = @Content)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    ShoppingItem createShoppingItem(@RequestBody ShoppingItem item) {

        shoppingItemRepository.save(item);
        return item;

    }

    @Operation(summary = "Updates an existing shopping item")
    @PutMapping(consumes = "application/json", produces = "application/json", path = "/{id}")
    ShoppingItem updateShoppingItem(@RequestBody ShoppingItem item){

        //TODO
        return null;

    }

    @Operation(summary = "Deletes a shopping item")
    @DeleteMapping(consumes = "application/json", produces = "application/json", path = "/{id}")
    ShoppingItem deleteShoppingItem(@PathVariable long id){

        this.shoppingItemRepository.deleteById(id);
        return null;

    }

    @Operation(summary = "Find a shopping item by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the item", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ShoppingItem.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Item not found", content = @Content) })
    @GetMapping(produces = "application/json", path = "/{id}")
    Optional<ShoppingItem> getShoppingItem(@PathVariable long id) {

        return shoppingItemRepository.findById(id);

    }

    @Operation(summary = "Returns a list of shopping items")
    @GetMapping(produces = "application/json")
    List<ShoppingItem> getShoppingItems(@RequestParam(required = false) String itemName) {

        List<ShoppingItem> shoppingItems = null;

        if (itemName != null) {

            shoppingItems = shoppingItemRepository.findByItemName(itemName);
        } else {

            shoppingItems = shoppingItemRepository.findAll();
        }

        return shoppingItems;

    }

    // @GetMapping(produces = "application/json")
    // List<ShoppingItem> getShoppingItems(){

    // List<ShoppingItem> shoppingItems = shoppingItemRepository.findAll();
    // return shoppingItems;

    // }

}
