package com.example.rentacar.model;

import com.example.rentacar.model.enums.Brand;
import com.example.rentacar.model.enums.CarType;
import com.example.rentacar.model.enums.Fuel;
import com.example.rentacar.model.enums.Location;
import com.example.rentacar.model.enums.Transmission;

import java.math.BigDecimal;
import java.util.UUID;

public class Car {
    private UUID uuid;
    private Gallery gallery;
    private Brand brand;
    private Location location;
    private CarType carType;
    private Fuel fuel;
    private Transmission transmission;
    private Integer horsePower;
    private Integer numberOfSeats;
    private Integer numberOfDoors;
    private Boolean airConditioner;
    private Boolean navigation;
    private BigDecimal cubicCapacity;
    private BigDecimal pricePerDay;
    private BigDecimal pricePerWeek;
    private BigDecimal pricePerMonth;

    public Car() {
        this.uuid = UUID.randomUUID();
    }

    public Car(Gallery gallery, Brand brand, Location location, CarType carType, Fuel fuel, Transmission transmission, Integer horsePower, Integer numberOfSeats, Integer numberOfDoors, Boolean airConditioner, Boolean navigation, BigDecimal cubicCapacity, BigDecimal pricePerDay, BigDecimal pricePerWeek, BigDecimal pricePerMonth) {
        this.uuid = UUID.randomUUID();
        this.gallery = gallery;
        this.brand = brand;
        this.location = location;
        this.carType = carType;
        this.fuel = fuel;
        this.transmission = transmission;
        this.horsePower = horsePower;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.airConditioner = airConditioner;
        this.navigation = navigation;
        this.cubicCapacity = cubicCapacity;
        this.pricePerDay = pricePerDay;
        this.pricePerWeek = pricePerWeek;
        this.pricePerMonth = pricePerMonth;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Boolean getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(Boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public Boolean getNavigation() {
        return navigation;
    }

    public void setNavigation(Boolean navigation) {
        this.navigation = navigation;
    }

    public BigDecimal getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(BigDecimal cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public BigDecimal getPricePerWeek() {
        return pricePerWeek;
    }

    public void setPricePerWeek(BigDecimal pricePerWeek) {
        this.pricePerWeek = pricePerWeek;
    }

    public BigDecimal getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(BigDecimal pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }
}
