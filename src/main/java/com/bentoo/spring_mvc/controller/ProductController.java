package com.bentoo.spring_mvc.controller;

import com.bentoo.spring_mvc.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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
}