package in.purvanshh.projectservice.controllers;

import in.purvanshh.projectservice.dtos.FakeStoreProductDTO;
import in.purvanshh.projectservice.models.Product;
import in.purvanshh.projectservice.services.FakeStoreProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This enables so we can interacts with HTTPS
@RestController
@RequestMapping("/products")
public class ProductControllers {

    FakeStoreProductService fakeStoreProductService;

    ProductControllers(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
            return fakeStoreProductService.getProductById(id);
    }

}
