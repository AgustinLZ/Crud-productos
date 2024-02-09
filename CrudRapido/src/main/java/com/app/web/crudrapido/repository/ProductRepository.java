package com.app.web.crudrapido.repository;


import com.app.web.crudrapido.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    default Optional<Product> findProductByName(String name) {
        return null;
    }
}

