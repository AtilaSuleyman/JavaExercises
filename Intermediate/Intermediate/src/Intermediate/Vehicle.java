package Intermediate;

public abstract class Vehicle {

    private int seatNo;
    private int wheelsNo;
    private String brand;
    private int topSpeed;
    private String id;
    private String vehicleType;

    public Vehicle(int seatNo, int wheelsNo,String brand, int topSpeed, String id, String vehicleType){

        this.seatNo = seatNo;
        this.wheelsNo = wheelsNo;
        this.brand = brand;
        this.topSpeed = topSpeed;
        this.id = id;
        this.vehicleType = vehicleType;

    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getWheelsNo() {
        return wheelsNo;
    }

    public void setWheelsNo(int wheelsNo) {
        this.wheelsNo = wheelsNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        brand = brand;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        topSpeed = topSpeed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
