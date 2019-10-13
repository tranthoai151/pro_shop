package com.pro.sho.web.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pro.sho.domain.Product;
import com.pro.sho.service.ProductService;
import com.pro.sho.service.dto.ProductDto;
import com.pro.sho.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(CategoryController.class);

    private static final String ENTITY_NAME = "product";

    @Autowired
    private ProductService productService;

    public ProductController(){}

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(value = "name", required = false) String name, Pageable pageable){
        log.debug("REST request to get a page of Products");
        final Page<Product> page = productService.searchProductByName(name, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/products");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDto> createProduct(@RequestParam String jsonProduct ,@RequestParam(required = false) MultipartFile imgProduct) throws IOException {
        log.debug("REST request to create Signature Request");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ProductDto productDto =  mapper.readValue(jsonProduct.toString(), ProductDto.class);
        ProductDto result = productService.save(productDto, imgProduct);
        return ResponseEntity.ok().body(result);    }
}
