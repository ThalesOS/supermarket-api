package br.com.thalesos.supermarket_api.service;

import br.com.thalesos.supermarket_api.model.Product;
import br.com.thalesos.supermarket_api.model.ShoppingCart;
import br.com.thalesos.supermarket_api.repository.ClientRepository;
import br.com.thalesos.supermarket_api.repository.ProductRepository;
import br.com.thalesos.supermarket_api.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository, ClientRepository clientRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }

    public ShoppingCart addProductToCart(int productId, int cartId){
        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(cartId);
        Optional<Product>optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent() && optionalShoppingCart.isPresent()){
            ShoppingCart cart = optionalShoppingCart.get();
            Product product = optionalProduct.get();

            cart.getProducts().add(product);
           return shoppingCartRepository.save(cart);
        }
        return null;
    }

    public Optional<ShoppingCart> getCartById (int cartId){

       return shoppingCartRepository.findById(cartId);
    }

    public ShoppingCart removeProducFromCart(int productId, int cartId){
        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(cartId);
        Optional<Product>optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent() && optionalShoppingCart.isPresent()){
            ShoppingCart cart = optionalShoppingCart.get();
            Product product = optionalProduct.get();
            cart.getProducts().remove(product);
            return shoppingCartRepository.save(cart);
        }
        return null;}
}

