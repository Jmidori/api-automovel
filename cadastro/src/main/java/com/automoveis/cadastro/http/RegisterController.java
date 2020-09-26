package com.automoveis.cadastro.http;

import com.automoveis.cadastro.CarRepository;
import com.automoveis.cadastro.entity.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RegisterController {

    private final CarRepository repository;

    public RegisterController(CarRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/cadastroAutomoveis")
    public ResponseEntity<Object> createCar(@RequestBody @Validated Car car){
        car.setRegisterDate(LocalDate.now());
        repository.save(car);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/automoveis")
    public List<Car> getAllCars(){
        return repository.findAll();
    }



}
