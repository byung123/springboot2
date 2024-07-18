package com.study.rest.controller;

import com.study.rest.entity.Car;
import com.study.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  요청 GET - /car
 *  CarEntity       --> model, color
 *
 *  CarRepository   --> Car findCarByModel(String model)
 *      --> List<Car>
 *          -> index0: Car(model: "소나타", color: "화이트")
 *          -> index1: Car(model: "K5", color: "블랙")
 *
 *  CarService      --> Car getCar(String model)
 *
 *  CarController   --> Car getCar(@RequestParam String model)
 *
 *  CarController(의존함) > CarService > CarRepository(의존받음) 순으로 의존한다
 */

@Controller
public class CarController {

    //  내가 쓴 답
//    @Autowired
//    CarService carService;
//
//    @ResponseBody
//    @GetMapping("/car")
//    public Car getCar(@RequestParam String model) {
//        return carService.getCar("소나타");
//    }

    @Autowired
    private CarService carService;

    @ResponseBody
    @GetMapping("/car")
    public Car getCar(@RequestParam String model) {
        return carService.getCar(model);
    }
}


