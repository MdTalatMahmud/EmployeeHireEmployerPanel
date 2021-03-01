package au.mgemployeehire.employeehire;

public class User {

    private String email, password, companyName, companyContactNumber, companyEmail, suburb, street, state;

    public User(){
        //default
    }

    public User(String email, String password, String companyName, String companyContactNumber, String companyEmail, String suburb, String street, String state) {
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.companyContactNumber = companyContactNumber;
        this.companyEmail = companyEmail;
        this.suburb = suburb;
        this.street = street;
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContactNumber() {
        return companyContactNumber;
    }

    public void setCompanyContactNumber(String companyContactNumber) {
        this.companyContactNumber = companyContactNumber;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
