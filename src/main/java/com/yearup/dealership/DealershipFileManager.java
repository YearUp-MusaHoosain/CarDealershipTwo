package com.yearup.dealership;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DealershipFileManager {

    // This Method gets all the Car Inventory from the inventory.csv
    public static Dealership getFromCSV(String dataFileName){
        ArrayList<Vehicle> carInventory = null;
        Dealership dealership = null;
        try{
            FileReader fr = new FileReader(dataFileName);
            BufferedReader br = new BufferedReader(fr);

            String[] firstLineData = br.readLine().split("\\|");
            dealership = new Dealership(firstLineData[0], firstLineData[1], firstLineData[2]);

            carInventory = dealership.getAllVehicles();
            String input;
            while( (input = br.readLine()) != null){
                String[] tokens = input.split(Pattern.quote("|"));
                int vinNumber = Integer.parseInt(tokens[0]);
                int yearNumber = Integer.parseInt(tokens[1]);
                String carMake = tokens[2];
                String carModel = tokens[3];
                String vehicleType = tokens[4];
                String carColor = tokens[5];
                int carOdometer = Integer.parseInt(tokens[6]);
                double carPrice = Double.parseDouble(tokens[7]);
                Vehicle v = new Vehicle(vinNumber, yearNumber, carMake, carModel, vehicleType, carColor, carOdometer, carPrice);
                carInventory.add(v);
            }
            br.close();
        }
        catch (Exception e){
            System.out.println("ERROR!!");
            e.printStackTrace();
        }
        return dealership;
    }

    // This Method writes car inventory info to the inventory.csv
    public static void saveDealership(Dealership dealership, String dataFileName){
        ArrayList<Vehicle> carInventory = dealership.getAllVehicles();
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(dataFileName));

            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber() + "\n");
//            bw.write("D & B Used Cars|111 Old Benbrook Rd|817-555-5555\n");

            for(Vehicle v : carInventory){
                bw.write( new StringBuilder()
                        .append(v.getVinNumber()).append("|")
                        .append(v.getYearNumber()).append("|")
                        .append(v.getCarMake()).append("|")
                        .append(v.getCarModel()).append("|")
                        .append(v.getVehicleType()).append("|")
                        .append(v.getCarColor()).append("|")
                        .append(v.getCarOdometer()).append("|")
                        .append(v.getCarPrice()).append("|").append("\n").toString());
            }

            bw.close();
        } catch (Exception e) {
            System.out.println("FILE WRITE ERROR");
            e.printStackTrace();
        }

    }
}
