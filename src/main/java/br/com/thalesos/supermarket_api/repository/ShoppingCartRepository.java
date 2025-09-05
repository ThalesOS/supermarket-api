package br.com.thalesos.supermarket_api.repository;

import br.com.thalesos.supermarket_api.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {
}
