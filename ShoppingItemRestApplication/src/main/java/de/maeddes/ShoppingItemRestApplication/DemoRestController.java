package de.maeddes.ShoppingItemRestApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

    final Logger logger = LoggerFactory.getLogger(de.maeddes.ShoppingItemRestApplication.DemoRestController.class);

    @Value("${HOSTNAME:not_found}")
    String hostname;

    @GetMapping
    public String sayHi(){

        logger.info("Hello from: "+hostname);
        return "Hello from: "+hostname;
    }

    @GetMapping("/ello")
    public String sayHello(){

        logger.info("Hello from: "+hostname);
        return "Hello from: "+hostname;
    }

    @GetMapping("/fail")
    public String fail(){

        logger.info("Failing from: "+hostname);
        //System.exit(1);
        return "you should not be here!";

    }
    
}
