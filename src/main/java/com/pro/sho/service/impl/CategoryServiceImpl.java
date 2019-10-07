package com.pro.sho.service.impl;

import com.pro.sho.repository.CategoryRepository;
import com.pro.sho.service.CategoryService;
import com.pro.sho.service.dto.CategoryDTO;
import com.pro.sho.service.mapper.CategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(){}

    @Override
    public Page<CategoryDTO> searchCategoryByName(String name, Pageable pageable) {
        log.debug("Request to search Category : {}", name);
        name = (name == null) ? "" : name;
        return categoryRepository.findAllByName(name, pageable).map(categoryMapper::toDto);
    }
}
