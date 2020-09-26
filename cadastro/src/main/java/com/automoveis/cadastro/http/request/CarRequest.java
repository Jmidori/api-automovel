package com.automoveis.cadastro.http.request;

import com.automoveis.cadastro.entity.enumerator.BRAND;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarRequest {
    private String brand;
    private String model;
    private BigDecimal price;
    private LocalDateTime registerDate;


}
