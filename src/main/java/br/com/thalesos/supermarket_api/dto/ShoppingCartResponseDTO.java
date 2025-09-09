package br.com.thalesos.supermarket_api.dto;

import java.util.List;

public record ShoppingCartResponseDTO(int id, ClientResponseDTO clientResponseDTO, List<ProductResponseDTO> products ) {
}
