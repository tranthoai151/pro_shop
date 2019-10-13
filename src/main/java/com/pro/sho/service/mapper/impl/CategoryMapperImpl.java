package com.pro.sho.service.mapper.impl;

import com.pro.sho.domain.Category;
import com.pro.sho.service.dto.CategoryDTO;
import com.pro.sho.service.mapper.CategoryMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryDTO toDto(Category category) {
        if(category == null){
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId( category.getId() );
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setStatus(category.getStatus());
        return categoryDTO;
    }

    @Override
    public List<Category> toEntity(List<CategoryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( dtoList.size() );
        for ( CategoryDTO categoryDTO : dtoList ) {
            list.add(toEntity( categoryDTO));
        }

        return list;
    }

    @Override
    public List<CategoryDTO> toDto(List<Category> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( entityList.size() );
        for ( Category category : entityList ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public Category toEntity(CategoryDTO categoryDTO) {
        if(categoryDTO == null){
            return null;
        }
        Category category = new Category();
        category.setId(categoryDTO.getId() );
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setStatus(categoryDTO.getStatus());
        return category;
    }
}
