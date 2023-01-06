package com.example.ecommerce_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "color")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    private  String name;
    @ManyToMany(mappedBy = "color",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productList;
}
