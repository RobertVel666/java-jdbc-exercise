package beans;

public class Returns {
    private int outlet_number;
    private int product_code;
    private int customer_id;
    private int return_date;
    private int return_time;
    private int quantity;
    private String reason;

    public int getOutlet_number() {return outlet_number;}

    public void setOutlet_number(int outlet_number) {this.outlet_number = outlet_number;}

    public int getProduct_code() {return product_code;}

    public void setProduct_code(int product_code) {this.product_code = product_code;}

    public int getCustomer_id() {return customer_id;}

    public void setCustomer_id(int customer_id) {this.customer_id = customer_id; }

    public int getReturn_date() {
        return return_date;
    }

    public void setReturn_date(int return_date) {
        this.return_date = return_date;
    }

    public int getReturn_time() {
        return return_time;
    }

    public void setReturn_time(int return_time) {
        this.return_time = return_time;
    }

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getReason() { return reason;}

    public void setReason(String reason) {this.reason = reason; }

}//Return
