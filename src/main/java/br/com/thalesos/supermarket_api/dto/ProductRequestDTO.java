package br.com.thalesos.supermarket_api.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(String name, BigDecimal price) {
}
