package com.davidlabs.catalogservice.domain;

class ProductMapper {

    public static Product toProduct(ProductEntity entity) {
        return new Product(
                entity.getCode(), entity.getName(), entity.getDescription(), entity.getImageUrl(), entity.getPrice());
    }
}
