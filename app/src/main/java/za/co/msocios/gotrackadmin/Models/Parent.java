package za.co.msocios.gotrackadmin.Models;

public class Parent {
    private String Email,Names,PhoneNumber;

    public Parent() {
    }

    public Parent(String email, String names, String phoneNumber) {
        Email = email;
        Names = names;
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
