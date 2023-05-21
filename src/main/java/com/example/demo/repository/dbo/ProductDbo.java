package com.example.demo.repository.dbo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

}
