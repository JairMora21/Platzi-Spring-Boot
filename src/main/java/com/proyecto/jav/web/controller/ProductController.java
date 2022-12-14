package com.proyecto.jav.web.controller;

import com.proyecto.jav.domain.Product;
import com.proyecto.jav.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //Estamos obteniendo informacion
    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct (@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping({"/category/{categoryId}"})
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save (@RequestBody  Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public  boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
