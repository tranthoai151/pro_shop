package com.pro.sho.service.mapper;

import com.pro.sho.domain.Product;
import com.pro.sho.service.dto.ProductDto;
import org.mapstruct.Mapper;

import java.io.IOException;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDto, Product> {
    ProductDto toDto(Product product) throws IOException;
    Product toEntity(ProductDto productDto);
}
