package com.pro.sho.service.mapper.impl;

import com.pro.sho.domain.Product;
import com.pro.sho.service.dto.ProductDto;
import com.pro.sho.service.mapper.ProductMapper;

import java.util.List;

public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductDto toDto(Product product) {
        return null;
    }

    @Override
    public List<Product> toEntity(List<ProductDto> dtoList) {
        return null;
    }

    @Override
    public List<ProductDto> toDto(List<Product> entityList) {
        return null;
    }

    @Override
    public Product toEntity(ProductDto productDto) {

        Product p = new Product();

        p.setId(productDto.getId());
        p.setCategory(productDto.getCategory());
        p.setName(productDto.getName());
        p.setPrice(productDto.getPrice());
        p.setImg(productDto.getImg());

        return p;
    }
}
