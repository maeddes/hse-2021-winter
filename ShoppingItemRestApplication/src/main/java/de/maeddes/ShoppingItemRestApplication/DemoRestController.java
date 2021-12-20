package de.maeddes.ShoppingItemRestApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

    @Value("${HOSTNAME:not_found}")
    String hostname;

    @GetMapping
    public String sayHi(){

        System.out.println("Hello from: "+hostname);
        return "Hello from: "+hostname;
    }

    @GetMapping("/ello")
    public String sayHello(){

        System.out.println("Hello from: "+hostname);
        return "Hello from: "+hostname;
    }

    @GetMapping("/fail")
    public String fail(){

        System.exit(1);
        return "you should not be here!";

    }
    
    
}
