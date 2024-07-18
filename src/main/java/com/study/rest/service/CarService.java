package com.study.rest.service;

import com.study.rest.entity.Car;
import com.study.rest.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CarService {

//    @Autowired
//    CarRepository carRepository;
//
//    public Car getCar(String model) {
//        return carRepository.findCarByModel(model);
//    }
    
    // final -> 상수 : 무조건 한 번은 초기화를 해야한다
//    private final CarRepository carRepository2 = null;

    private CarRepository carRepository1;

    public CarService(CarRepository carRepository) {
        this.carRepository1 = carRepository;
    } // 이런식으로도 주입 가능

    @Autowired
    private CarRepository carRepository;

    public Car getCar(String model) {
        return carRepository.findCarByModel(model);
    }
}
