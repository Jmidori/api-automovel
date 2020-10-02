package com.automoveis.cadastro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Car {
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
    @Column(name = "dataCadastro")
    private LocalDate registerDate;

    public Car() {
    }

    public Car(String marca, String modelo, BigDecimal valor, LocalDate dataCadastro) {
        this.brand = marca;
        this.model = modelo;
        this.price = valor;
        this.registerDate = dataCadastro;
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
}
