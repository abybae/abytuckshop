package com.abytuckshop;

import com.abytuckshop.entity.Product;
import com.abytuckshop.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AbyTuckshopApplication  {
    public static void main(String[] args) {
        SpringApplication.run(AbyTuckshopApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(ProductRepository repository) {
        return (args) -> {
            repository.save(new Product("Lakka Beans", "Sweet sugar beans with salad cream", 5, 3));
            repository.save(new Product("Banana Cake", "Eight inch fruit cake with fresh creame inside.", 3, 2));
            repository.save(new Product("Apple Crumble", "A yummy homemade downfall fresh green apple crumble.", 2, 4));
        };
    }
}
