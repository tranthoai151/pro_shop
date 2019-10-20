package com.pro.sho.repository;

import com.pro.sho.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE CONCAT('%',:productName,'%') AND status = 1")
    Page<Product> searchProductByName(@Param("productName") String productName, Pageable pageable);
}
