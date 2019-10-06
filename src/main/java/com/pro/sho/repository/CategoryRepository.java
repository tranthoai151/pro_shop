package com.pro.sho.repository;

import com.pro.sho.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@SuppressWarnings("unused")
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT c FROM Category c WHERE c.name LIKE CONCAT('%',:categoryName,'%')")
    Page<Category> findAllByName(@Param("categoryName") String categoryName, Pageable pageable);
}
