package com.bentoo.spring_mvc.controller;

import com.bentoo.spring_mvc.model.Product;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping
public  class ProductController {
    private List<Product> products = Arrays.asList(
            new Product("Camiseta", 49.90),
            new Product("Calça Jeans", 99.90),
            new Product("Tênis", 199.90)
    );
    @GetMapping
    public String GetProducts(Model model){

        model.addAttribute("products",products);
        return "index";
    }
    @GetMapping("/{id}")
    public String GetProductDetails(@PathVariable UUID id, Model model){
        var productExists = products.stream().filter(item->item.id.equals(id)).findFirst();
        if(!productExists.isEmpty()){
            model.addAttribute("product",productExists.get());
            System.out.println(productExists.get());
            return "details";
        }
        return "Product doesn't exists";
    }
}