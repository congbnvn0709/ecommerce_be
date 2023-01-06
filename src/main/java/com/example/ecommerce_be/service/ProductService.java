package com.example.ecommerce_be.service;

import com.example.ecommerce_be.dto.ProductDTO;
import com.example.ecommerce_be.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProduct();

    Product addNewProduct(ProductDTO productDTO);

    Product updateProduct (ProductDTO productDTO);
}
