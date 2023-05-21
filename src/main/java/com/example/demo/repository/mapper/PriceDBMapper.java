package com.example.demo.repository.mapper;

import com.example.demo.repository.dbo.BrandDbo;
import com.example.demo.repository.dbo.PriceDbo;
import com.example.demo.repository.dbo.ProductDbo;
import com.example.demo.service.entities.Brand;
import com.example.demo.service.entities.Price;
import com.example.demo.service.entities.Product;

public class PriceDBMapper {
    public static Price priceDboToDomain(PriceDbo priceDbo) {
        Price price = new Price();
        price.setPrice(priceDbo.getPrice());
        price.setPriceList(priceDbo.getPriceList());
        price.setCurr(priceDbo.getCurr());
        price.setPriority(priceDbo.getPriority());
        price.setStartDate(priceDbo.getStartDate());
        price.setEndDate(priceDbo.getEndDate());
        price.setProduct(PriceDBMapper.productDboToDomain(priceDbo.getProduct()));
        price.setBrand(PriceDBMapper.brandDboToDomain(priceDbo.getBrand()));
        return price;
    }

    public static Product productDboToDomain(ProductDbo productDbo) {
        Product product = new Product();
        product.setProductId(productDbo.getProductId());
        return product;
    }

    public static Brand brandDboToDomain(BrandDbo brandDbo) {
        Brand brand = new Brand();
        brand.setBrandId(brandDbo.getBrandId());
        brand.setName(brandDbo.getName());
        return brand;
    }
}
