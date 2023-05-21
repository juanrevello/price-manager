package com.example.demo.controller;

import com.example.demo.controller.dto.ResponseDto;
import com.example.demo.controller.mapper.ResponseMapper;
import com.example.demo.service.IPriceService;
import com.example.demo.utils.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/product")
public class PriceController {

    private IPriceService priceService;

    public PriceController(IPriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(("/{productId}"))
    public ResponseEntity<ResponseDto> getPrice(@RequestParam(value = "date") String date,
                                                @RequestParam(value = "brand_id") Long brandId,
                                                @PathVariable Long productId) {

        LocalDateTime parsedDate = DateUtil.parseToRequest(date);
        ResponseDto response = ResponseMapper.domainToDto(priceService.getActivePrice(productId, brandId, parsedDate));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
