package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.ResponseDto;
import com.example.demo.service.entities.Price;

import java.time.format.DateTimeFormatter;

public class ResponseMapper {
    public static ResponseDto domainToDto(Price price) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setBrandId(price.getBrand().getBrandId());
        responseDto.setPrice(price.getPrice());
        responseDto.setPriceList(price.getPriceList());
        responseDto.setProductId(price.getProduct().getProductId());
        responseDto.setStartDate(price.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        responseDto.setEndDate(price.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return responseDto;
    }
}
