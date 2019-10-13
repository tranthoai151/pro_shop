package com.pro.sho.service;

import com.pro.sho.domain.Product;
import com.pro.sho.service.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    Page<Product> searchProductByName(String name, Pageable pageable);

    ProductDto save(ProductDto productDto, MultipartFile signature);

}
