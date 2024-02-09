package com.app.web.crudrapido.service;


import com.app.web.crudrapido.product.Product;
import com.app.web.crudrapido.repository.ProductRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return this.productRepository.findAll();

    }

    public ResponseEntity<Object> newProduct(Product product) {
        Optional<Product> res = productRepository.findProductByName(product.getNombre());
        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("error", true);
            datos.put("message", "Ya existe un producto con ese nombre ");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT

            );
        }
        productRepository.save(product);
        datos.put("data", product);
        datos.put("message", "se guardó con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }


}




