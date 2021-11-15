package com.example.controller;

import com.example.dto.CarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/v1")
public class TestController {

    //Create Car
    //Get Car by Id
    //List Cars
    //Delete Car
    //Update Car

    private List<CarDTO> cars = new ArrayList<>();
    private int count;

    @GetMapping("/cars")
    public List<CarDTO> getAllCars()
    {
        return cars;
    }

    @PostMapping("/cars")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CarDTO addCar(@RequestBody CarDTO carDTO)
    {
        count++;
        carDTO.setId((long) count);
        cars.add(carDTO);
        return carDTO;
    }

    @GetMapping("/cars/{id}")
    public CarDTO getCarById(@PathVariable Long id) throws Exception {
        return cars.stream()
                .filter(car->car.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new Exception("Car not found"));
    }

    @PutMapping("/cars/{id}")
    public CarDTO updatecar(@RequestBody CarDTO carDTO,@PathVariable Long id) throws Exception {
        CarDTO carr = cars.stream()
                .filter(car->car.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new Exception("Car not found"));
        carr.setColor(carDTO.getColor());
        return carr;
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCarById(@PathVariable Long id)
    {
        cars.removeIf(car->car.getId().equals(id));
    }
}
