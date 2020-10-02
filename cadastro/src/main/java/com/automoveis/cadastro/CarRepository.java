package com.automoveis.cadastro;

import com.automoveis.cadastro.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
