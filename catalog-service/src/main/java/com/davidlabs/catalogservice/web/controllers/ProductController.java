package com.davidlabs.catalogservice.web.controllers;

import com.davidlabs.catalogservice.domain.PagedResult;
import com.davidlabs.catalogservice.domain.Product;
import com.davidlabs.catalogservice.domain.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    Product getProductByCode(@PathVariable String code) {
        return productService.getProductByCode(code);
    }
}
