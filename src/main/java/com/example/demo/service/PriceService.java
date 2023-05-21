package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.IPriceRepository;
import com.example.demo.service.entities.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService implements IPriceService {

    IPriceRepository priceRepository;

    public PriceService(IPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getActivePrice(Long productId, Long brandId, LocalDateTime date) {

        Price price = priceRepository.getPriceForParams(productId, brandId, date);
        if (price != null) {
            return price;
        } else {
            throw new NotFoundException("not found in data base");
        }
    }
}
