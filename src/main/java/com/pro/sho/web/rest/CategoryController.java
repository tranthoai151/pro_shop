package com.pro.sho.web.rest;

import com.pro.sho.service.CategoryService;
import com.pro.sho.service.dto.CategoryDTO;
import com.pro.sho.web.rest.util.PaginationUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;


import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final Logger log = LoggerFactory.getLogger(CategoryController.class);

    private static final String ENTITY_NAME = "category";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories/name")
    public ResponseEntity<List<CategoryDTO>> getAllCategorySearchByName(@RequestParam(value = "name", required = false) String name, Pageable pageable){
        log.debug("REST request to get a page of Companies");
        final Page<CategoryDTO> page = categoryService.searchCategoryByName(name, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/categories/name");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
