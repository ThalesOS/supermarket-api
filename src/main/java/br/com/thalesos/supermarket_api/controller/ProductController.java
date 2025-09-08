package br.com.thalesos.supermarket_api.controller;

import br.com.thalesos.supermarket_api.dto.ProductRequestDTO;
import br.com.thalesos.supermarket_api.dto.ProductResponseDTO;
import br.com.thalesos.supermarket_api.model.Product;
import br.com.thalesos.supermarket_api.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ProductResponseDTO addProduct(@RequestBody ProductRequestDTO requestDTO) {

        Product newProduct = new Product();
        newProduct.setName(requestDTO.name());
        newProduct.setPrice(requestDTO.price());

        Product savedProduct = productService.addProduct(newProduct);

        return new ProductResponseDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice()
        );
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProduct(){

        List<Product> productList = productService.getAllProduct();
        List<ProductResponseDTO> responseDTOList =  new ArrayList<>();

        for (Product product : productList) {

            ProductResponseDTO responseDTO = new ProductResponseDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice()
            );

            responseDTOList.add(responseDTO);

        }
        return responseDTOList;

    }

    @PutMapping("/products/{id}")
    public ProductResponseDTO updateProductById(@PathVariable int id, @RequestBody ProductRequestDTO requestDTO) {

        Product productDetails = new Product();
        productDetails.setName(requestDTO.name());
        productDetails.setPrice(requestDTO.price());

        Product updatedProduct = productService.updateProductById(id, productDetails);

        if (updatedProduct != null) {
            return new ProductResponseDTO(
                    updatedProduct.getId(),
                    updatedProduct.getName(),
                    updatedProduct.getPrice()
            );
        }

        return null;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable int id){
        productService.deleteProductById(id);
    }




    }


