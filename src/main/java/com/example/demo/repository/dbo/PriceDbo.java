package com.example.demo.repository.dbo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "prices")
public class PriceDbo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceList;

    private Integer priority;

    private Double price;

    private String curr;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDateTime startDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandDbo brand;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDbo product;

}

