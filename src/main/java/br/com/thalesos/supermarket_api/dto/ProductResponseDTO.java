package br.com.thalesos.supermarket_api.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(int id, String name, BigDecimal price) {
}

