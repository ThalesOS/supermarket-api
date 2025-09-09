package br.com.thalesos.supermarket_api.controller;

import br.com.thalesos.supermarket_api.dto.ClientResponseDTO;
import br.com.thalesos.supermarket_api.dto.ProductResponseDTO;
import br.com.thalesos.supermarket_api.dto.ShoppingCartResponseDTO;
import br.com.thalesos.supermarket_api.model.ShoppingCart;
import br.com.thalesos.supermarket_api.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping("/carts/{id}")
    public ShoppingCartResponseDTO getCartById(@PathVariable int id) {

        Optional<ShoppingCart> optionalCart = shoppingCartService.getCartById(id);

        return optionalCart.map(this::convertToDTO).orElse(null);
    }



    @PostMapping("/carts/{cartId}/products/{productId}")
    public ShoppingCartResponseDTO addProductToCart(@PathVariable int cartId, @PathVariable int productId) {

        ShoppingCart updatedCart = shoppingCartService.addProductToCart(cartId, productId);

        if (updatedCart != null) {
            return convertToDTO(updatedCart);
        }

        return null;
    }

    @DeleteMapping("/carts/{cartId}/products/{productId}")
    public ShoppingCartResponseDTO removeProductFromCart(@PathVariable int cartId, @PathVariable int productId) {

        ShoppingCart updatedCart = shoppingCartService.removeProducFromCart(cartId, productId);

        if (updatedCart != null) {
            return convertToDTO(updatedCart);
        }

        return null;
    }

    private ShoppingCartResponseDTO convertToDTO(ShoppingCart cart) {

        ClientResponseDTO clientDTO = new ClientResponseDTO(
                cart.getClient().getId(),
                cart.getClient().getName()
        );

        List<ProductResponseDTO> productDTOs = cart.getProducts().stream()
                .map(product -> new ProductResponseDTO(product.getId(), product.getName(), product.getPrice()))
                .collect(Collectors.toList());

        return new ShoppingCartResponseDTO(
                cart.getId(),
                clientDTO,
                productDTOs
        );
    }
}