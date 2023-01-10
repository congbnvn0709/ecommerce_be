package com.example.ecommerce_be.controller;

import com.example.ecommerce_be.base.BaseResponse;
import com.example.ecommerce_be.constants.StatusCode;
import com.example.ecommerce_be.dto.ProductDTO;
import com.example.ecommerce_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/product")
@CrossOrigin(origins = "localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity getAllProduct() {
        return ResponseEntity.ok(new BaseResponse(productService.getAllProduct(),"Thành công", StatusCode.SUCCESS));
    }

    @PostMapping("/addProduct")
    @ResponseBody
    ResponseEntity addNewProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new BaseResponse(productService.addNewProduct(productDTO),"Thêm mới sản phẩm thành công",StatusCode.SUCCESS));
    }

    @PutMapping("/updateProduct")
    @ResponseBody
    ResponseEntity updateProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new BaseResponse(productService.updateProduct(productDTO),"Cập nhật sản phẩm thành công",StatusCode.SUCCESS));
    }

    @DeleteMapping("/deleteProduct/{id}")
    ResponseEntity deleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteProduct(id);
        return  ResponseEntity.ok(new BaseResponse(null,"Xóa sản phẩm thành công",StatusCode.SUCCESS));
    }


    @GetMapping("/getById/{id}")
    ResponseEntity getProductById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
