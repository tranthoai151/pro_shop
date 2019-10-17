package com.pro.sho.service;

import com.pro.sho.domain.Product;
import com.pro.sho.service.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    Page<ProductDto> searchProductByName(String name, Pageable pageable) throws IOException;

    ProductDto save(ProductDto productDto, MultipartFile signature);

}
