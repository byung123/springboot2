package com.study.rest.repository;


import com.study.rest.entity.Car;
import com.study.rest.service.CarService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {

//
//    Car index0 = Car.builder()
//            .model("소나타")
//            .color("white")
//            .build();
//    Car index1 = Car.builder()
//            .model("K5")
//            .color("black")
//            .build();
//
//    List<Car> cars = new ArrayList<>();
//    cars.add
//
//    public Car findCarByModel(String model) {
//        if(model.equals("소나타")) {
//            Car findCar = cars[0];
//        }
//        return findCar;
//    }

    private List<Car> carList = List.of(
            Car.builder().model("소나타").color("white").build(),
            Car.builder().model("K5").color("black").build()
    );

    public Car findCarByModel(String model) {
        return carList.stream().filter(car -> car.getModel().equals(model))
                .collect(Collectors.toList())
                .get(0);
    }
}
