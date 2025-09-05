package br.com.thalesos.supermarket_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor@AllArgsConstructor
@Entity
public class ShoppingCart {
    @Id @GeneratedValue
    private int id;
    @OneToOne
    private Client client;
    @OneToMany
    private Product product;


}
