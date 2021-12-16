package de.maeddes.ShoppingItemThymeleafUI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("play")
public class ShoppingItemPlayAroundController {

    @Value("${backend.endpoint}")
	private String shoppingApplicationEndpoint;

    @GetMapping("/")
	public String displayPage(Model model){

        System.out.println("tuuuut" + shoppingApplicationEndpoint);

        WebClient.create(shoppingApplicationEndpoint)
            .get()
            .retrieve()
            .bodyToMono(Item[].class);
            
        //    .block();

        // Item[] items = WebClient
        //     .create("http://localhost:8080/items/")
        //     .get()
        //     .retrieve()
        //     .bodyToMono(Item[].class)
        //     .block();

		return "hey "+shoppingApplicationEndpoint;
	}

    @GetMapping("/getItemAsObject") 
    public String simpleCallObject(){

        return WebClient
            .create("http://localhost:8080/items/1")
            .get()
            .retrieve()
            .bodyToMono(Item.class)
            .block()
            .toString();

    }

    @GetMapping("/deleteItem") 
    public void deleteItem(){

        System.out.println("Delete invoked with : 1");

        WebClient
            .create("http://localhost:8080/items/1")
            .delete()
            .retrieve()
            .bodyToMono(Void.class)
            .block();

        return;

    }
}
