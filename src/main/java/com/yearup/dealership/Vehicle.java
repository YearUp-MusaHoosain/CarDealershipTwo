package com.yearup.dealership;

public class Vehicle {

    private int vinNumber;
    private int yearNumber;
    private String carMake;
    private String carModel;
    private String vehicleType;
    private String carColor;
    private int carOdometer;
    private double carPrice;

    public Vehicle(){}

    public Vehicle(int vinNumber, int yearNumber, String carMake, String carModel, String vehicleType, String carColor, int carOdometer, double carPrice) {
        this.vinNumber = vinNumber;
        this.yearNumber = yearNumber;
        this.carMake = carMake;
        this.carModel = carModel;
        this.vehicleType = vehicleType;
        this.carColor = carColor;
        this.carOdometer = carOdometer;
        this.carPrice = carPrice;
    }

    public int getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(int vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getCarOdometer() {
        return carOdometer;
    }

    public void setCarOdometer(int carOdometer) {
        this.carOdometer = carOdometer;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                getVinNumber(),
                getYearNumber(),
                getCarMake(),
                getCarModel(),
                getVehicleType(),
                getCarColor(),
                getCarOdometer(),
                getCarPrice());
    }
}
