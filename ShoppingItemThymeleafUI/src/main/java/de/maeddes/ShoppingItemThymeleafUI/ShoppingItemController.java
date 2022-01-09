package de.maeddes.ShoppingItemThymeleafUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Controller
public class ShoppingItemController {
    
    
    Logger logger = LoggerFactory.getLogger(de.maeddes.ShoppingItemThymeleafUI.ShoppingItemController.class);
    
    @Value("${backend.endpoint}")
    private String shoppingApplicationEndpoint;

    @GetMapping("/")
    public String displayPage(Model model) {

        Item[] items = WebClient
                .create(shoppingApplicationEndpoint)
                .get()
                .retrieve()
                .bodyToMono(Item[].class)
                .block();

        model.addAttribute("items", items);

        return "page";
    }

    @PostMapping("/create")
	public String addItem(@RequestParam String newItem, @RequestParam int amount, Model model){

        Item item = new Item();
        item.setName(newItem);
        item.setQuantity(amount);

        System.out.println("New item: "+item);

        WebClient
            .create(shoppingApplicationEndpoint)
            .post()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(item), Item.class)
            .retrieve()
            .bodyToMono(Item.class)
            .block();

        return "redirect:/";
	}

    @PostMapping("/delete")
    public String deleteItem(@RequestParam long id){

        System.out.println("Delete invoked with : "+id);

        WebClient
            .create(shoppingApplicationEndpoint+id)
            .delete()
            .retrieve()
            .bodyToMono(Void.class)
            .block();

        return "redirect:/";

    }
    
}
