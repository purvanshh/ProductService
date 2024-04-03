package in.purvanshh.projectservice.controllers;

import in.purvanshh.projectservice.dtos.FakeStoreProductDTO;
import in.purvanshh.projectservice.dtos.ExceptionDTO;
import in.purvanshh.projectservice.models.Product;
import in.purvanshh.projectservice.services.FakeStoreProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Objects;
// This enables so we can interacts with HTTPS
@RestController
@RequestMapping("/products")
public class ProductControllers {

    FakeStoreProductService fakeStoreProductService;

    ProductControllers(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id){
        ResponseEntity<Object> responseEntity = null;
        try{
            Product product =  fakeStoreProductService.getProductById(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        }catch (RuntimeException exception) {
            ExceptionDTO exceptionDTO = new ExceptionDTO();
            exceptionDTO.setMessage("Something Went Wrong");
            exceptionDTO.setResolution("Do Nothing");
            responseEntity = new ResponseEntity<>(exceptionDTO,HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

}
