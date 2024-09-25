package com.example.rentacar.model;

import com.example.rentacar.R;
import com.example.rentacar.model.Car;
import com.example.rentacar.model.Gallery;
import com.example.rentacar.model.enums.Brand;
import com.example.rentacar.model.enums.CarType;
import com.example.rentacar.model.enums.Fuel;
import com.example.rentacar.model.enums.Location;
import com.example.rentacar.model.enums.Transmission;
import com.example.rentacar.model.enums.UserType;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InternalDataBase {

    private static List<Car> carList;
    private static Customer customer = new Customer("Paul", "Pavlovic", UserType.PREMIUM);


    private InternalDataBase() {
    }

    public static List<Car> getCarList() {
        if (carList == null) {
            carList = new ArrayList<>();
            initRentACarData(carList);
        }
        return carList;
    }

    public static List<Car> getCarAvailable() {
        List<Car> carList = InternalDataBase.getCarList();
        //filter the data for dates
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if(car.getAvailability().isAvailable(GlobalVariables.getStartAt(), GlobalVariables.getReturnAt())) {
                result.add(car);
            }
        }
        return result;
    }

    public static Customer getCustomer() {
        return customer;
    }

    private static void initRentACarData(@NotNull List<Car> carList) {


        Gallery f30 = new Gallery();
        f30.getImages().add(R.drawable.f30);
        Car car1 = new Car(f30, Brand.BMW, Location.SARAJEVO, CarType.SEDAN, Fuel.DIESEL, Transmission.AUTOMATIC,
                184, 5, 5, true,
                true, BigDecimal.valueOf(2.0), BigDecimal.valueOf(123),
                BigDecimal.valueOf(100), BigDecimal.valueOf(80), 2012);
        Gallery fiat = new Gallery();
        fiat.getImages().add(R.drawable.fiat);
        Car car2 = new Car(fiat, Brand.FIAT, Location.TRAVNIK, CarType.HATCHBACK, Fuel.GASOLINE, Transmission.MANUAL,
                110, 5, 3, true,
                true, BigDecimal.valueOf(2.0), BigDecimal.valueOf(56),
                BigDecimal.valueOf(100), BigDecimal.valueOf(80), 2019);
        Gallery leon = new Gallery();
        leon.getImages().add(R.drawable.leon);
        Car car3 = new Car(leon, Brand.SEAT, Location.BIHAC, CarType.SUV, Fuel.HYBRID, Transmission.AUTOMATIC,
                184, 5, 5, true,
                true, BigDecimal.valueOf(2.0), BigDecimal.valueOf(70),
                BigDecimal.valueOf(100), BigDecimal.valueOf(80), 2018);
        Gallery merc = new Gallery();
        merc.getImages().add(R.drawable.merc_c);
        Car car4 = new Car(merc, Brand.MERCEDES, Location.SARAJEVO, CarType.SEDAN, Fuel.ELECTRIC, Transmission.AUTOMATIC,
                184, 5, 5, true,
                true, BigDecimal.valueOf(2.0), BigDecimal.valueOf(110),
                BigDecimal.valueOf(100), BigDecimal.valueOf(80), 2018);
        Gallery porsche = new Gallery();
        porsche.getImages().add(R.drawable.porsche);
        Car car5 = new Car(porsche, Brand.PORSCHE, Location.SARAJEVO, CarType.SUPERCAR, Fuel.DIESEL, Transmission.AUTOMATIC,
                184, 5, 5, true,
                true, BigDecimal.valueOf(2.0), BigDecimal.valueOf(150),
                BigDecimal.valueOf(100), BigDecimal.valueOf(80), 2018);
        Gallery s5 = new Gallery();
        s5.getImages().add(R.drawable.s5);
        Car car6 = new Car(s5, Brand.AUDI, Location.SARAJEVO, CarType.SEDAN, Fuel.DIESEL, Transmission.MANUAL,
                184, 5, 5, true,
                true, BigDecimal.valueOf(2.0), BigDecimal.valueOf(100),
                BigDecimal.valueOf(100), BigDecimal.valueOf(80), 2018);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
    }
}
