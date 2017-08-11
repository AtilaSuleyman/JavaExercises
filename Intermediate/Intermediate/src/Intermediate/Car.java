package Intermediate;

public class Car extends Vehicle
{
    int numberOfDoors;

    public Car(int seatNo, int wheelsNo, String brand, int topSpeed,
               String id, String vehicleType, int numberOfDoors){
        super(seatNo, wheelsNo,brand,topSpeed,id,vehicleType);
        this.numberOfDoors = numberOfDoors;
    }
}
