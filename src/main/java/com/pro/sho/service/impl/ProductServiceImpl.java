package com.pro.sho.service.impl;

import com.pro.sho.domain.Product;
import com.pro.sho.repository.ProductRepository;
import com.pro.sho.service.ProductService;
import com.pro.sho.service.dto.ProductDto;
import com.pro.sho.service.mapper.ProductMapper;
import com.pro.sho.web.rest.util.FileStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(){}

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Page<Product> searchProductByName(String name, Pageable pageable) {
        log.debug("Request to search Products : {}", name);
        return productRepository.searchProductByName(name, pageable);
    }

    @Override
    public ProductDto save(ProductDto productDto, MultipartFile photoProduct) {
        try {
            FileStore.createFile(photoProduct);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = productMapper.toEntity(productDto);
        product.setImg(photoProduct.getOriginalFilename());
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

}
