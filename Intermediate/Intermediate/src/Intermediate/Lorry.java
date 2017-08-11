package Intermediate;

public class Lorry extends Vehicle{

    int maxLoadAmount;

    public Lorry(int seatNo, int wheelsNo, String brand, int topSpeed,
                 String id, String vehicleType, int maxLoadAmount){

        super(seatNo, wheelsNo,brand,topSpeed,id,vehicleType);
        this.maxLoadAmount = maxLoadAmount;
    }


}
