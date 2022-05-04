package beans;

public class Sales {
    private int outlet_number;
    private int emp_number;
    private int customer_id;
    private int product_code;
    private int sale_date;
    private int sale_time;
    private int quantity;


    public int getOutlet_number() {return outlet_number; }

    public void setOutlet_number(int outlet_number) {this.outlet_number = outlet_number; }

    public int getEmp_number() {return emp_number;}

    public void setEmp_number(int emp_number) {this.emp_number = emp_number;}

    public int getCustomer_id() {return customer_id;}

    public void setCustomer_id(int customer_id) {this.customer_id = customer_id;}

    public int getProduct_code() {return product_code;}

    public void setProduct_code(int product_code) {this.product_code = product_code;}

    public int getSale_date() {        return sale_date;    }

    public void setSale_date(int sale_date) {this.sale_date = sale_date;    }

    public int getSale_time() {
        return sale_time;
    }

    public void setSale_time(int sale_time) {
        this.sale_time = sale_time;
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {this.quantity = quantity; }

}//Sales
