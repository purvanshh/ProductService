package in.purvanshh.projectservice.services;

import in.purvanshh.projectservice.exceptions.CategoryNotFound;
import in.purvanshh.projectservice.exceptions.ProductNotFound;
import in.purvanshh.projectservice.models.Category;
import in.purvanshh.projectservice.models.Product;
import in.purvanshh.projectservice.repositories.CategoryRepository;
import in.purvanshh.projectservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFound(id, "Product not found");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null) { // save the category
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if (optionalCategory.isEmpty()) {
            //The category that is passed in the input product in invalid.
            throw new CategoryNotFound("Invalid category id passed");
        }

        product1.setCategory(optionalCategory.get());
        return product1;
    }
}