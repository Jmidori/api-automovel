package com.automoveis.pagamento.http.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class BoletoRequestImpl implements IPaymentRequest {

    @NotBlank(message = "campo marca é obrigatorio")
    @JsonProperty("marca")
    private String brand;
    @NotBlank(message = "campo modelo é obrigatorio")
    @JsonProperty("modelo")
    private String model;
    @NotEmpty(message = "o campo valor nao pode ser nulo")
    @JsonProperty("valor")
    private String price;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }
}
