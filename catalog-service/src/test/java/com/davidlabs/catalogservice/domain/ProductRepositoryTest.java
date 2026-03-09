package com.davidlabs.catalogservice.domain;

import com.davidlabs.catalogservice.ContainersConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(
        properties = {
                "spring.test.database.replace=NONE",
                "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///testdb"
        })
//@Import(ContainersConfig.class)
@Sql("/test-data.sql")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void shouldGetAllProducts() {
        List<ProductEntity> products = repository.findAll();
        assertThat(products).hasSize(15);
    }
}