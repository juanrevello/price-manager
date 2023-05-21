package com.example.demo.repository;

import com.example.demo.service.entities.Price;

import java.time.LocalDateTime;

public interface IPriceRepository {
    Price getPriceForParams(Long productId, Long brandId, LocalDateTime date);
}
