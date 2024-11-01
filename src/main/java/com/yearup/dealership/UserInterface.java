package com.yearup.dealership;

public class UserInterface {

    public static String dataFileName = "inventory.csv";
    private Dealership currentDealership;

    public UserInterface(){
        currentDealership = DealershipFileManager.getFromCSV(dataFileName);
    }

    public void display(){
        do {
            try{
//                StringBuilder sb = new StringBuilder(
//                        "\n" +
//                        "--".repeat(55) +
//                        "WELCOME TO " + currentdealership.getName() + " APPLICATION!" +
//                        "Please select from the following:" +
//                        "\n" +
//                        "1 - Find vehicles within a price range" +
//                        "2 - Find vehicles by make / model" +
//                        "3 - Find vehicles by year range" +
//                        "4 - Find vehicles by color" +
//                        "5 - Find vehicles by mileage range" +
//                        "6 - Find vehicles by type (car, truck, SUV, van)" +
//                        "7 - List ALL vehicles" +
//                        "8 - Add a vehicle" +
//                        "9 - Remove a vehicle" +
//                        "99 - Quit\n");
                System.out.println();
                System.out.println("--".repeat(55));
                System.out.println("WELCOME TO " + currentDealership.getName() + " APPLICATION!");
                System.out.println("Please select from the following:");
                System.out.println("\n");
                System.out.println("1 - Find vehicles within a price range");
                System.out.println("2 - Find vehicles by make / model");
                System.out.println("3 - Find vehicles by year range");
                System.out.println("4 - Find vehicles by color");
                System.out.println("5 - Find vehicles by mileage range");
                System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
                System.out.println("7 - List ALL vehicles");
                System.out.println("8 - Add a vehicle");
                System.out.println("9 - Remove a vehicle");
                System.out.println("99 - Quit\n");
                System.out.print("+++ (Home Screen) Choose a Command: ");

                int option = Console.PromptForInt();

                switch(option){
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetAllVehicles();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 99:
                        System.out.println("Exiting Application. Thank you for using this application!");
                        return;
                    default:
                        System.out.println("Invalid Number, please try again.");

                }
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("ERROR, please try again with valid commands.");
            }
        } while(true);
    }

    public void displayVehicles(Vehicle v){
        System.out.println(v);

    }

    public void processGetAllVehicles(){
        for(Vehicle v: currentDealership.getAllVehicles()){
            displayVehicles(v);
        }
    }

    public void processAddVehicleRequest(){
        int vin = Console.PromptForInt("Enter Vin: ");
        int year = Console.PromptForInt("Enter year: ");
        String make = Console.PromptForString("Enter make: ");
        String model = Console.PromptForString("Enter model: ");
        String vehicleType = Console.PromptForString("Enter vehicle type: ");
        String color = Console.PromptForString("Enter color:  ");
        int odometer = Console.PromptForInt("Enter odometer: ");
        double price = Console.PromptForDouble("Enter price: ");

        this.currentDealership.addVehicle(vin, year, make, model, vehicleType, color, odometer, price);
        DealershipFileManager.saveDealership(currentDealership, dataFileName);
    }

    public void processRemoveVehicleRequest(){
        int vin = Console.PromptForInt("Enter Vin of the vehicle you want to remove: ");

        currentDealership.removeVehicle(vin);
        DealershipFileManager.saveDealership(currentDealership, dataFileName);
    }

    public void processGetByPriceRequest(){
//        double price = Console.PromptForDouble("Enter price: ");
//
//        for (Vehicle v : currentDealership) {
//            if (v.getCarPrice() == price) {
//                System.out.println(v.toString());
//            }
//        }
    }

    public void processGetByMakeModelRequest(){}

    public void processGetByYearRequest(){}

    public void processGetByColorRequest(){}

    public void processGetByMileageRequest(){}

    public void processGetByVehicleTypeRequest(){}


}
