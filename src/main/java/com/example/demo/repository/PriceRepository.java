package com.example.demo.repository;

import com.example.demo.repository.db.IPriceJPARepository;
import com.example.demo.repository.dbo.PriceDbo;
import com.example.demo.repository.mapper.PriceDBMapper;
import com.example.demo.service.entities.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PriceRepository implements IPriceRepository{

    IPriceJPARepository priceJPARepository;

    public PriceRepository(IPriceJPARepository priceJPARepository) {
        this.priceJPARepository = priceJPARepository;
    }

    @Override
    public Price getPriceForParams(Long productId, Long brandId, LocalDateTime date) {
        Optional<PriceDbo> priceDboOptional = priceJPARepository.findActivePrice(productId, brandId, date);
        if (priceDboOptional.isPresent()) {
            return PriceDBMapper.priceDboToDomain(priceDboOptional.get());
        } else {
            return null;
        }
    }
}
