package com.pro.sho.service.mapper;

import com.pro.sho.domain.Category;
import com.pro.sho.service.dto.CategoryDTO;

public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {

    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO categoryDTO);
}
