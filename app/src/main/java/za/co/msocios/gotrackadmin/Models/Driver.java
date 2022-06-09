package za.co.msocios.gotrackadmin.Models;

public class Driver {

    private String Names,Surname,CarName,CarReg,DriverImage;

    public Driver() {
    }

    public Driver(String names, String surname, String vehicle, String vihicleReg, String driverImage) {

        Names = names;
        Surname = surname;
        CarName = vehicle;
        CarReg = vihicleReg;
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

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarReg() {
        return CarReg;
    }

    public void setCarReg(String carReg) {
        CarReg = carReg;
    }

    public String getDriverImage() {
        return DriverImage;
    }

    public void setDriverImage(String driverImage) {
        DriverImage = driverImage;
    }
}
