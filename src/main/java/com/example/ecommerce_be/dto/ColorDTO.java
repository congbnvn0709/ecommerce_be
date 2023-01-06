package com.example.ecommerce_be.dto;

import com.example.ecommerce_be.entity.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ColorDTO {
    private long id;

    private String code;

    private  String name;
    private List<ProductDTO> productList;
}
