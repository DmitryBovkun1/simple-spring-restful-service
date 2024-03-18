package org.example.demorestful;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final List<Product> products = new ArrayList<>();

    @GetMapping(produces = {"application/json", "application/xml"})
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public Product getProductById(@PathVariable Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping(consumes = {"application/json", "application/xml"})
    public void addProduct(@RequestBody Product product) {
        products.add(product);
    }

    @PutMapping(value = "/{id}", consumes = {"application/json", "application/xml"})
    public void updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .ifPresent(product -> {
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                });
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
