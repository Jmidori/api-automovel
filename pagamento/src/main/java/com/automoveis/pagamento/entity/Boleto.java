package com.automoveis.pagamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Boleto {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "marca")
    private String brand;
    @Column(name = "modelo")
    private String model;
    @Column(name = "valor")
    private BigDecimal price;
    @Column(name = "dataVencimento")
    private LocalDate maturityDate;
    @Column(name = "codigoBoleto")
    private String boletoCode;

    public Boleto() {}

    public Boleto(String brand, String model, BigDecimal price, LocalDate maturityDate, String boletoCode) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.maturityDate = maturityDate;
        this.boletoCode = boletoCode;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getBoletoCode() {
        return boletoCode;
    }

    public void setBoletoCode(String boletoCode) {
        this.boletoCode = boletoCode;
    }

}
