package com.example.demo.service;

import com.example.demo.service.entities.Price;

import java.time.LocalDateTime;

public interface IPriceService {
    Price getActivePrice(Long productId, Long brandId, LocalDateTime date);
}
