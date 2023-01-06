package com.example.ecommerce_be.dto;

import com.example.ecommerce_be.entity.Color;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private long id;
    private String productCode;
    private String productName;
    private String description;
    private String status;
    private List<String> color;
    private Long price;
    private Integer isActive;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String createdBy;
    private String updatedBy;
}
