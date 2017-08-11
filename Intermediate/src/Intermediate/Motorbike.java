package Intermediate;

public class Motorbike extends Vehicle {

    int bikeCC;

    public Motorbike(int seatNo, int wheelsNo, String brand, int topSpeed,
                     String id, String vehicleType, int bikeCC){

        super(seatNo, wheelsNo,brand,topSpeed,id,vehicleType);
        this.bikeCC = bikeCC;

    }
}
