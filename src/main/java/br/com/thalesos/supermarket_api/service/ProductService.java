package br.com.thalesos.supermarket_api.service;

import br.com.thalesos.supermarket_api.model.Product;
import br.com.thalesos.supermarket_api.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducut(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProductById (int id, Product newProductDetails){

        Optional <Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()){

            Product productToUpdate = optionalProduct.get();
            productToUpdate.setName(newProductDetails.getName());
            productToUpdate.setPrice(newProductDetails.getPrice());

            return productRepository.save(productToUpdate);

        }
        return null;
    }

    public void deleteProductById(int id){
        productRepository.deleteById(id);
    }

}




