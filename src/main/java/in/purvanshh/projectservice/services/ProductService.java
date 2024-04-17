package in.purvanshh.projectservice.services;

import in.purvanshh.projectservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);
}