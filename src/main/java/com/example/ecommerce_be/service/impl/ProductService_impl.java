package com.example.ecommerce_be.service.impl;

import com.example.ecommerce_be.dto.ProductDTO;
import com.example.ecommerce_be.entity.Color;
import com.example.ecommerce_be.entity.Product;
import com.example.ecommerce_be.mapper.ProductMapper;
import com.example.ecommerce_be.repositories.ColorRepository;
import com.example.ecommerce_be.repositories.ProductRepository;
import com.example.ecommerce_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService_impl implements ProductService {

    @Autowired
    private ProductRepository  productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<ProductDTO> getAllProduct() {
        return productMapper.toDtos(productRepository.findAll());
    }

    @Override
    public Product addNewProduct(ProductDTO productDTO) {
          List<String> lstColor =  productDTO.getColor();
          Product product = productMapper.toEntity(productDTO);
          List<Color> colorList = lstColor.stream().map(item ->
             colorRepository.searchColorByCode(item)
          ).collect(Collectors.toList());
          product.setColor(colorList);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductDTO productDTO) {
        return productRepository.save(productMapper.toEntity(productDTO));
    }
}
