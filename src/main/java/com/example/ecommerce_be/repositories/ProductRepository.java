package com.example.ecommerce_be.repositories;

import com.example.ecommerce_be.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p from Product p where p.isActive =1 order by p.updatedDate")
    List<Product> getAllProduct();


    @Query ("SELECT p from Product p where p.isActive =1 and p.id = ?1")
    Optional<Product> getProductById(Long id);

    @Modifying
    @Query(value = "update Product p set p.id = ?1 where p.isActive = 1",nativeQuery = true)
    void deleteProductById(Long id);

}
