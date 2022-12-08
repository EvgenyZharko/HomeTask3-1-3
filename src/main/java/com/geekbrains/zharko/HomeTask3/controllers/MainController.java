package com.geekbrains.zharko.HomeTask3.controllers;

import com.geekbrains.zharko.HomeTask3.data.Product;
import com.geekbrains.zharko.HomeTask3.repositories.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private ProductsRepository prodRep;

    public MainController(ProductsRepository prodRep) {
        this.prodRep = prodRep;
    }

    @GetMapping("/products/{id}")
    public String showProductInfo(Model model, @PathVariable Long id) {
        Product product = prodRep.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        model.addAttribute("products", prodRep.getAllProducts());
        return "products_page";
    }

    ololo
}
