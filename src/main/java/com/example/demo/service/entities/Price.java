package com.example.demo.service.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Price {

    private Long priceList;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Product product;
    private Integer priority;
    private Double price;
    private String curr;
}
