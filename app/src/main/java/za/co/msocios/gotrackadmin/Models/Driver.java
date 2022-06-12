package za.co.msocios.gotrackadmin.Models;

public class Driver {

    private String Names,Surname,Email,PhoneNumber,ResidentialAdress,CarReg,CarName,Status,DriverUID,License;

    public Driver() {
    }

    public Driver(String names, String surname, String email, String phoneNumber, String residentialAdress, String carReg, String carName, String status, String driverUID,String license) {
        Names = names;
        Surname = surname;
        Email = email;
        PhoneNumber = phoneNumber;
        ResidentialAdress = residentialAdress;
        CarReg = carReg;
        CarName = carName;
        Status = status;
        DriverUID = driverUID;
        License = license;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getResidentialAdress() {
        return ResidentialAdress;
    }

    public void setResidentialAdress(String residentialAdress) {
        ResidentialAdress = residentialAdress;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDriverUID() {
        return DriverUID;
    }

    public void setDriverUID(String driverUID) {
        DriverUID = driverUID;
    }

    public String getLicense() {
        return License;
    }

    public void setLicense(String license) {
        License = license;
    }
}
