package Intermediate;

import java.util.ArrayList;
import java.util.Iterator;

public class Garage {


    ArrayList<Vehicle> garage;

    public Garage(){
        garage = new ArrayList<>();
    }

    public void initialiseGarage(){
        Car c = new Car(4,4,"BMW",230,"C123","Car",4);
        garage.add(c);
        Motorbike b = new Motorbike(4,4,"Volvo",200,"B223","Motorbike",50);
        garage.add(b);
        Lorry l = new Lorry(4,4,"Mercedes",160,"L345","Lorry",500);
        garage.add(l);
        Car c1 = new Car(4,4,"BMW",230,"C193","Car",4);
        garage.add(c1);
    }

    public double getAmountForFix(String vehicleType){
        double sum = 0;
        switch (vehicleType){

            case "Car":
                sum = 149.99;
                break;
            case "Motorbike":
                sum = 99.99;
                break;
            case "Lorry":
                sum = 249.99;
                break;
            default:
                break;

        }
        return sum;
    }

    public double calculateBill(){
        double sum = 0;
        for(Vehicle v : garage){
            sum = sum + getAmountForFix(v.getVehicleType());
        }
        System.out.println("£"+sum);
        return sum;
    }

    public void addMotorbike(int seatNo, int wheelsNo, String brand, int topSpeed,
                                           String id, String vehicleType, int bikeCC) {
        Motorbike m = new Motorbike(seatNo,wheelsNo, brand, topSpeed, id, vehicleType, bikeCC);
        garage.add(m);
    }

    public void addCar(int seatNo, int wheelsNo, String brand, int topSpeed,
                             String id, String vehicleType, int numberOfDoors) {
        Car c = new Car(seatNo,wheelsNo, brand, topSpeed, id, vehicleType, numberOfDoors);
        garage.add(c);
    }

    public void addLorry(int seatNo, int wheelsNo, String brand, int topSpeed,
                             String id, String vehicleType, int maxLoadAmount) {
        Lorry l = new Lorry(seatNo,wheelsNo, brand, topSpeed, id, vehicleType, maxLoadAmount);
        garage.add(l);
    }

    public void addVehicle(Vehicle v){
        garage.add(v);
    }

    public ArrayList<Vehicle> getGarage() {
        return garage;
    }

    public void removeById(String id){
        if(!garage.isEmpty()){
            for(Vehicle v : garage){
                if(id.equalsIgnoreCase(v.getId())){
                    garage.remove(v);
                    System.out.println("your vehicle was removed!");
                    break;
                }
            }
        }
    }

    public void removeByVehicleType(String vehicleType){
        if(!garage.isEmpty()){
            Iterator itr = garage.iterator();
            while(itr.hasNext()){
                Vehicle vehicle = (Vehicle) itr.next();
                if(vehicleType.equalsIgnoreCase(vehicle.getVehicleType())){
                    itr.remove();
                    System.out.println("your vehicle was removed!");
                }
            }
        }
    }

    public void emptyGarage(){
        garage.clear();
    }

    public void printVehicleNames(){
        for(Vehicle v : garage){
            System.out.println(v.getBrand());
        }
    }
}
