package com.automoveis.pagamento.http.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class BoletoResponseImpl implements IPaymentResponse{

    @JsonProperty("codigoBoleto")
    private String boletoCode;
    @JsonProperty("dataVencimento")
    private LocalDate maturityDate;
    @JsonProperty("valor")
    private String value;

    public String getBoletoCode() {
        return boletoCode;
    }

    public void setBoletoCode(String boletoCode) {
        this.boletoCode = boletoCode;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
