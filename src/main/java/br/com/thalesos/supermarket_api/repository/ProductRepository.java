package br.com.thalesos.supermarket_api.repository;

import br.com.thalesos.supermarket_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
