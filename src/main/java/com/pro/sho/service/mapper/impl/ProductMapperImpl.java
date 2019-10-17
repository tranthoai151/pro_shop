package com.pro.sho.service.mapper.impl;

import com.pro.sho.domain.Product;
import com.pro.sho.service.dto.ProductDto;
import com.pro.sho.service.mapper.ProductMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductMapperImpl implements ProductMapper {

    public String getFile(String img) throws IOException {
        Resource resource = new ClassPathResource("/img/"+ img);
        File file = resource.getFile();
        return file.getAbsolutePath();
    }



    @Override
    public ProductDto toDto(Product product) {
        if (product == null){
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setCategory(product.getCategory());
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        try {
            productDto.setImg(getFile(product.getImg()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productDto;
    }

    @Override
    public List<Product> toEntity(List<ProductDto> dtoList) {
        return null;
    }

    @Override
    public List<ProductDto> toDto(List<Product> entityList) {
        if(entityList == null){
            return null;
        }
        List<ProductDto> list = new ArrayList<>(entityList.size());
        for (Product product :entityList) {
            list.add(toDto(product));
        }
        return list;

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
