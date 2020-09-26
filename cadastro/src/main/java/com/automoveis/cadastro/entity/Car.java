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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car))
            return false;
        Car automovel = (Car) o;
        return Objects.equals(this.id, automovel.id)
                && Objects.equals(this.brand, automovel.brand)
                && Objects.equals(this.model, automovel.model)
                && Objects.equals(this.price, automovel.price)
                && Objects.equals(this.registerDate, automovel.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, price, registerDate);
    }
}
