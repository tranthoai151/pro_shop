package com.pro.sho.service;

import com.pro.sho.service.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CategoryService {
    Page<CategoryDTO> searchCategoryByName(String name, Pageable pageable);
}
