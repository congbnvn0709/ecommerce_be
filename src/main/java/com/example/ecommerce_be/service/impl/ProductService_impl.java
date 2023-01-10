package com.example.ecommerce_be.service.impl;

import com.example.ecommerce_be.base.HandleError;
import com.example.ecommerce_be.base.NotFoundException;
import com.example.ecommerce_be.constants.Status;
import com.example.ecommerce_be.dto.ProductDTO;
import com.example.ecommerce_be.entity.Color;
import com.example.ecommerce_be.entity.Product;
import com.example.ecommerce_be.mapper.ProductMapper;
import com.example.ecommerce_be.repositories.ColorRepository;
import com.example.ecommerce_be.repositories.ProductRepository;
import com.example.ecommerce_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService_impl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<ProductDTO> getAllProduct() {
        return productMapper.toDtos(productRepository.getAllProduct());
    }

    @Override
    @Transactional
    public ProductDTO addNewProduct(ProductDTO productDTO) {
        List<String> lstColor = productDTO.getColor();
        Product product = productMapper.toEntity(productDTO);
        List<Color> colorList = lstColor.stream().map(item ->
                colorRepository.searchColorByCode(item)
        ).collect(Collectors.toList());
        product.setColor(colorList);
        product.setStatus(String.valueOf(Status.NEW));
        product.setCreatedDate(new Date());
        product.setUpdatedDate(new Date());
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Optional<Product> product = checkProduct(productDTO.getId());
        if (product.isPresent()) {
            return  productMapper.toDto(productRepository.save(productMapper.toEntity(productDTO)));

        } else {
            throw new NotFoundException("Product not found");
        }
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productMapper.toDto(productRepository.getProductById(id).orElseThrow(() -> new NotFoundException("Product by id" + id + "not found")));
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Optional<Product> product = checkProduct(id);
        if (product.isPresent()) {
            productRepository.deleteProductById(id);
        } else {
            throw new NotFoundException("Product not found");
        }
    }

    public Optional<Product> checkProduct(Long id) {
        return productRepository.getProductById(id);
    }


}
