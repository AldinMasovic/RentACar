package com.example.rentacar;

import com.example.rentacar.model.Car;
import com.example.rentacar.model.Gallery;
import com.example.rentacar.model.enums.Brand;
import com.example.rentacar.model.enums.CarType;
import com.example.rentacar.model.enums.Fuel;
import com.example.rentacar.model.enums.Location;
import com.example.rentacar.model.enums.Transmission;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InternalDataBase {

    private static List<Car> carList;

    private InternalDataBase() {
    }

    public static List<Car> getCarList() {
        if (carList == null) {
            carList = new ArrayList<>();
            initRentACarData(carList);
        }
        return carList;
    }

    private static void initRentACarData(@NotNull List<Car> carList) {

        Gallery gallery = new Gallery();
        gallery.getImages().add(R.drawable.ic_launcher_background);

        Car car1 = new Car(gallery, Brand.BMW, Location.SARAJEVO, CarType.SEDAN, Fuel.DIESEL, Transmission.AUTOMATIC,
                184, 5, 5, true,
                true, BigDecimal.valueOf(2.0), BigDecimal.valueOf(123),
                BigDecimal.valueOf(100), BigDecimal.valueOf(80));
        Car car2 = new Car(gallery, Brand.BMW, Location.SARAJEVO, CarType.SEDAN, Fuel.DIESEL, Transmission.AUTOMATIC,
                184, 5, 5, true,
                true, BigDecimal.valueOf(2.0), BigDecimal.valueOf(123),
                BigDecimal.valueOf(100), BigDecimal.valueOf(80));
        Car car3 = new Car(gallery, Brand.BMW, Location.SARAJEVO, CarType.SEDAN, Fuel.DIESEL, Transmission.AUTOMATIC,
                184, 5, 5, true,
                true, BigDecimal.valueOf(2.0), BigDecimal.valueOf(123),
                BigDecimal.valueOf(100), BigDecimal.valueOf(80));
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
    }
}
