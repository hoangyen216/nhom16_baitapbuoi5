package com.buoi4.product;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.validation.Path;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public String index(Model model) {
    	model.addAttribute("listproduct", productService.GetAll());
    	return "product/index";
    }
    
    
    @GetMapping("/create")
    public String create (Model model) {
    	model.addAttribute("product", new Product());
    	return "product/create";
    }
    
    @PostMapping("/create")
    public String create(@Valid Product newProduct,  BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", newProduct);
            return "product/create";
        }


        productService.add(newProduct);
        return "redirect:/products";
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
