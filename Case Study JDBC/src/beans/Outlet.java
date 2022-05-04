package beans;

public class Outlet {
    private int outlet_number;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phone;

    public int getOutlet_number() {
        return outlet_number;
    }

    public void setOutlet_number(int outlet_number) {
        this.outlet_number = outlet_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
