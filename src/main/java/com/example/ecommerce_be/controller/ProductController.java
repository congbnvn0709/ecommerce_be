package com.example.ecommerce_be.controller;

import com.example.ecommerce_be.dto.ProductDTO;
import com.example.ecommerce_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    @ResponseBody
    ResponseEntity getAllProduct() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getAllProduct());
    }

    @PostMapping("/addProduct")
    @ResponseBody
    ResponseEntity addNewProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.addNewProduct(productDTO));
    }

    @PutMapping("/updateProduct")
    @ResponseBody
    ResponseEntity updateProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.addNewProduct(productDTO));
    }

    @DeleteMapping("/deleteProduct/{id}")
    ResponseEntity deleteProduct(@PathVariable(name = "id") Long id){
        return  ResponseEntity.ok().build();
    }
}
