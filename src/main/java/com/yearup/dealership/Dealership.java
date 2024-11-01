package com.yearup.dealership;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> carInventory;

    public Dealership(){}

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.carInventory = new ArrayList<Vehicle>();
    }


    public void addVehicle(int vinNumber, int yearNumber, String carMake, String carModel, String vehicleType, String carColor, int carOdometer, double carPrice){
        carInventory.add(new Vehicle(vinNumber, yearNumber, carMake, carModel, vehicleType, carColor, carOdometer, carPrice));
    }

    public void removeVehicle(int vinNumber){
        Vehicle vehicleToRemove = null;

        for (Vehicle v : carInventory){
            if (v.getVinNumber() == vinNumber){
                vehicleToRemove = v;
            }
        }
        if (vehicleToRemove != null) {
            carInventory.remove(vehicleToRemove);
            System.out.println("Vehicle with VIN " + vinNumber + " removed.");
        } else {
            System.out.println("Vehicle with VIN " + vinNumber + " not found.");
        }

    }

    public ArrayList<Vehicle> getAllVehicles(){
        return carInventory;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
