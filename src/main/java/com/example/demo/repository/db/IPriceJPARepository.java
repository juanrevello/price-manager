package com.example.demo.repository.db;

import com.example.demo.repository.dbo.PriceDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface IPriceJPARepository extends JpaRepository<PriceDbo, Long> {
    @Override
    Optional<PriceDbo> findById(Long aLong);

    @Query(value = "SELECT * FROM prices p " +
            "WHERE :date BETWEEN p.start_date AND p.end_date " +
            "AND :productId = p.product_id " +
            "AND :brandId = p.brand_id " +
            "ORDER BY p.priority DESC " +
            "LIMIT 1;", nativeQuery = true
    )
    Optional<PriceDbo> findActivePrice(@Param("productId") Long productId,
                                       @Param("brandId") Long brandId,
                                       @Param("date") LocalDateTime date);
}
