package za.co.msocios.gotrackadmin.Models;

public class Child {

    private  String FullNames,SchoolName,Grade,Address,DateOfBirth,Image,InTime,OutTime,Driver,State;

    public Child() {

    }

    public Child(String fullNames, String schoolName, String grade, String address, String dateOfBirth, String image, String inTime, String outTime, String driver,String state) {
        FullNames = fullNames;
        SchoolName = schoolName;
        Grade = grade;
        Address = address;
        DateOfBirth = dateOfBirth;
        Image = image;
        InTime = inTime;
        OutTime = outTime;
        Driver = driver;
        State = state;
    }

    public String getFullNames() {
        return FullNames;
    }

    public void setFullNames(String fullNames) {
        FullNames = fullNames;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getInTime() {
        return InTime;
    }

    public void setInTime(String inTime) {
        InTime = inTime;
    }

    public String getOutTime() {
        return OutTime;
    }

    public void setOutTime(String outTime) {
        OutTime = outTime;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
