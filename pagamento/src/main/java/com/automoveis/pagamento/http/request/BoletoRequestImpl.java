package com.automoveis.pagamento.http.request;

import com.automoveis.pagamento.entity.Boleto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;


public class BoletoRequestImpl implements IPaymentRequest {

    @JsonProperty("marca")
    private String brand;
    @JsonProperty("modelo")
    private String model;
    @NonNull
    @JsonProperty("valor")
    private BigDecimal price;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
