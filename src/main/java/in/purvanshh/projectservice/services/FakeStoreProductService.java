package in.purvanshh.projectservice.services;

import in.purvanshh.projectservice.dtos.FakeStoreProductDTO;
import in.purvanshh.projectservice.models.Category;
import in.purvanshh.projectservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;
    @Override
    public Product getProductById(Long id) {

        // get the product by using id from here

        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);

        return mapFakeStoreProductDTOToProduct(fakeStoreProductDTO);
    }

    public Product mapFakeStoreProductDTOToProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        // Check if data is null
        if (fakeStoreProductDTO == null) {
            return null;
        }

        // Map data to Product object
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());

        // Map category
        Category category = new Category();
        category.setDescription(fakeStoreProductDTO.getCategory());
        product.setCategory(category);

        return product;
    }
}
