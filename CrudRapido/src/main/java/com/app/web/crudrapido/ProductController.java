package com.app.web.crudrapido;


import com.app.web.crudrapido.product.Product;
import com.app.web.crudrapido.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;
    private Product product;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> regisatrarProducto(@RequestBody Product product) {
        this.product = product;
        return this.productService.newProduct(product);
    }


}
