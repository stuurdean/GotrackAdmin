package za.co.msocios.gotrackadmin.Models;

public class Driver {

    private String Names,Surname,Vehicle,VihicleReg,DriverImage;

    public Driver() {
    }

    public Driver(String names, String surname, String vehicle, String vihicleReg, String driverImage) {

        Names = names;
        Surname = surname;
        Vehicle = vehicle;
        VihicleReg = vihicleReg;
        DriverImage = driverImage;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getVehicle() {
        return Vehicle;
    }

    public void setVehicle(String vehicle) {
        Vehicle = vehicle;
    }

    public String getVihicleReg() {
        return VihicleReg;
    }

    public void setVihicleReg(String vihicleReg) {
        VihicleReg = vihicleReg;
    }

    public String getDriverImage() {
        return DriverImage;
    }

    public void setDriverImage(String driverImage) {
        DriverImage = driverImage;
    }
}
