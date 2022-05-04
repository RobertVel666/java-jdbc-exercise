import Tables.*;

import beans.*;
import beans.Product;
import util.DBType;
import util.DBUtil;

import java.sql.*;
import java.util.Scanner;

public class Outlet_connection {



    public static void main(String[] args) {

        try {

            System.out.println("Connected :)");
            System.out.println(":::MAIN MENU::: ");
            System.out.println("1 Sale/return processing");
            System.out.println("2 Outlet/employee/customer/product maintenance");
            System.out.println("3 Reports");
            System.out.println("4 Quit");
            Scanner main_menu;
            main_menu = new Scanner(System.in);

            switch (main_menu.nextInt()) {
                case 1:
                    System.out.println("::SALES/RETURN MENU::");
                    System.out.println("1 Process a sale");
                    System.out.println("2 Process a return");
                    System.out.println("3 View a sale (given date and customer id)");
                    System.out.println("4 View a return (given date and customer id)");
                    System.out.println("5 Quit");
                    Scanner sales_return_answer;
                    sales_return_answer = new Scanner(System.in);
                    switch (sales_return_answer.nextInt()) {
                        case 1:
                            System.out.println("::PROCESS A SALE::");
                            Outlet_connection.process_sale();
                            break;
                        case 2:
                            System.out.println("::PROCESS A RETURN::");
                            Outlet_connection.process_return();
                            break;
                        case 3:
                            System.out.println("::VIEW A SALE::");
                            Outlet_connection.View_sales();
                            break;
                        case 4:
                            System.out.println("::VIEW A RETURN::");
                            Outlet_connection.View_returns();
                            break;
                        case 5:
                            System.out.println("YOU QUIT OUT THE SYSTEM");
                            break;}//switch sales/return processing
                    break;
                case 2:
                    System.out.println("MAINTENANCE MENU");
                    System.out.println("1 Add/modify/drop outlet");
                    System.out.println("2 Add/modify/drop employee");
                    System.out.println("3 Add/modify/drop customer");
                    System.out.println("4 Add/modify/drop product");
                    System.out.println("5 Process new shipment of products for an outlet");
                    System.out.println("6 Process returns");
                    System.out.println("7 Quit");
                    Scanner maintenance_answer;
                    maintenance_answer = new Scanner(System.in);
                    switch (maintenance_answer.nextInt()){
                        case 1:
                            System.out.println("1 Add Outlet");
                            System.out.println("2 Modify Outlet");
                            System.out.println("3 Drop Outlet");
                            Scanner answer_Maintenance;
                            answer_Maintenance = new Scanner(System.in);switch (answer_Maintenance.nextInt()){
                                        case 1:
                                            System.out.println("::ADD OUTLET::");
                                            Outlet_connection.Add_Outlet();
                                            break;
                                        case 2:
                                            System.out.println("::UPDATE OUTLET::");
                                            Outlet_connection.Modify_Outlet();
                                            break;
                                        case 3:
                                            System.out.println("::DELETE OUTLET::");
                                            Outlet_connection.Delete_Outlet();
                                            break;
                                    }//answer outlet
                            break;
                        case 2:
                            System.out.println("1 Add Employee");
                            System.out.println("2 Modify Employee");
                            System.out.println("3 Drop Employee");
                            answer_Maintenance = new Scanner(System.in);
                            switch (answer_Maintenance.nextInt()){
                                        case 1:
                                            System.out.println("::ADD EMPLOYEE::");
                                            Outlet_connection.Add_Employee();
                                            break;
                                        case 2:
                                            System.out.println("::UPDATE EMPLOYEE::");
                                            Outlet_connection.Modify_Employee();
                                            break;
                                        case 3:
                                            System.out.println("::DELETE EMPLOYEE::");
                                            Outlet_connection.Delete_Employee();
                                            break;
                                    }//answer employee
                            break;
                        case 3:
                            System.out.println("1 Add Customer");
                            System.out.println("2 Modify Customer");
                            System.out.println("3 Drop Customer");
                            answer_Maintenance = new Scanner(System.in);
                            switch (answer_Maintenance.nextInt()){
                                        case 1:
                                            System.out.println("::ADD CUSTOMER::");
                                            Outlet_connection.Add_Customer();
                                            break;
                                        case 2:
                                            System.out.println("::UPDATE CUSTOMER::");
                                            Outlet_connection.Modify_Customer();
                                            break;
                                        case 3:
                                            System.out.println("::DELETE CUSTOMER::");
                                            Outlet_connection.Delete_Customer();
                                            break;
                                    }//answer customer
                            break;
                        case 4:
                            System.out.println("1 Add Product");
                            System.out.println("2 Modify Product");
                            System.out.println("3 Drop Product");
                            answer_Maintenance = new Scanner(System.in);
                            switch (answer_Maintenance.nextInt()){
                                        case 1:
                                            System.out.println("::ADD PRODUCT::");
                                            Outlet_connection.Add_Product();
                                            break;
                                        case 2:
                                            System.out.println("::UPDATE PRODUCT::");
                                            Outlet_connection.Modify_Product();
                                            break;
                                        case 3:
                                            System.out.println("::DELETE PRODUCT::");
                                            Outlet_connection.Delete_Product();
                                            break;
                                    }//answer customer
                            break;
                        case 5:
                            System.out.println("::PROCESS NEW SHIPMENT OF PRODUCTS FOR AN OUTLET::");
                            Outlet_connection.Add_Shipment_Outlet();
                            break;
                        case 6:
                            System.out.println("::PROCESS RETURNS::");
                            Outlet_connection.process_returns2();
                            break;
                        case 7:
                            System.out.println("YOU QUIT OUT THE SYSTEM");
                            break;
                            }//switch maintenance_answer
                    break;
                case 3:
                    System.out.println("REPORTS");
                    System.out.println("1 Produce yearly sales report for outlet");
                    System.out.println("2 Produce sales report for employee");
                    System.out.println("3 Produce the list of the top 10 selling items");
                    System.out.println("4 Quit");
                    Scanner reports_answer;
                    reports_answer = new Scanner(System.in);
                    switch (reports_answer.nextInt()){
                        case 1:
                            Outlet_connection.yearly_report();
                            break;
                        case 2:
                            Outlet_connection.report_employee();
                            break;
                        case 3:
                            System.out.println("TOP 10 SELLING ITEMS");
                            Outlet_connection.top_ten();
                            break;
                        case 4:
                            System.out.println("YOU QUIT OUT THE SYSTEM");
                            break;
                    }//switch reports
                    break;
                case 4:
                    System.out.println("YOU QUIT OUT THE SYSTEM");
                    break;

                    }//switch
            }//try
        catch(Exception e){
                System.err.println();
            }//catch

    } //main


    //1.1 PROCESS A SALE
    public static void  process_sale() throws SQLException {

        ProductManager.displayAllRows();

        Sales bean = new Sales();
        bean.setOutlet_number(InputHelper.getIntegerInput("Outlet Number: "));
        bean.setCustomer_id(InputHelper.getIntegerInput("Customer ID: "));
        bean.setProduct_code(InputHelper.getIntegerInput("Product Code: "));
        bean.setQuantity(InputHelper.getIntegerInput("Quantity: "));

        boolean result = SalesManager.process_sale(bean);
        if (result){
            System.out.println("Your sale is complete!");
            System.out.println("Have a nice day!");
        }//if

    }//PROCESS A SALE

    //1.2 PROCESS A RETURN
    public static void  process_return() throws SQLException {

        System.out.println("WE ARE SORRY, PLEASE COMPLETE THE NEXT INFORMATION: ");

        Returns bean = new Returns();
        bean.setOutlet_number(InputHelper.getIntegerInput("Outlet Number: "));
        bean.setProduct_code(InputHelper.getIntegerInput("Product Code:"));
        bean.setCustomer_id(InputHelper.getIntegerInput("Customer ID:"));
        bean.setProduct_code(InputHelper.getIntegerInput("Quantity: "));
        bean.setQuantity(InputHelper.getIntegerInput("Reason: "));

        boolean result = ReturnsManager.process_return(bean);
        if (result){
            System.out.println("Your sale is complete!");
            System.out.println("Thanks for your visit");
        }//if

    }//PROCESS A RETURN

    //1.3 VIEW A SALES
    public static void View_sales() throws Exception {
        SalesManager.displayAllRows();

        int customer_id = InputHelper.getIntegerInput("ENTER THE CUSTOMER NUMBER: ");

        Sales bean = SalesManager.getRow(customer_id);
        if(bean == null){
            System.err.println("No customer number were found");
        }//if
        else{
            System.out.println("Outlet Number: " + bean.getOutlet_number());
            System.out.println("Employee Number: " + bean.getEmp_number());
            System.out.println("Customer id: " + bean.getCustomer_id());
            System.out.println("Product Code: " + bean.getProduct_code());
            System.out.println("Sale Date: " + bean.getSale_date());
            System.out.println("Sale Time: " + bean.getSale_time());
            System.out.println("Quantity: " + bean.getQuantity());
        }//else


    }//VIEW A SALES

    //1.4 VIEW A RETURN
    public static void View_returns() throws Exception {
        int customer_id = InputHelper.getIntegerInput("ENTER THE CUSTOMER NUMBER: ");

        Returns bean = ReturnsManager.getRow(customer_id);
        if(bean == null){
            System.err.println("No customer number were found");
        }//if
        else {
            System.out.println("Outlet Number: " + bean.getOutlet_number());
            System.out.println("Product Code: " + bean.getProduct_code());
            System.out.println("Customer id: " + bean.getCustomer_id());
            System.out.println("Return Date: " + bean.getReturn_date());
            System.out.println("Return Time: " + bean.getReturn_time());
            System.out.println("Quantity: " + bean.getQuantity());
            System.out.println("Reason: " + bean.getReason());
        }//else
    }//VIEW A RETURN

    //2.1.1 ADD OUTLET
    public static void Add_Outlet() throws Exception {

        OutletManager.displayAllRows();

        Outlet bean = new Outlet();
        bean.setOutlet_number(InputHelper.getIntegerInput("Outlet Number:"));
        bean.setAddress(InputHelper.getInput("Address: "));
        bean.setCity(InputHelper.getInput("City: "));
        bean.setState(InputHelper.getInput("State: "));
        bean.setZip(InputHelper.getIntegerInput("Zip: "));
        bean.setPhone(InputHelper.getInput("Phone: "));

        boolean result = OutletManager.insert(bean);
        if (result){
            System.out.println("New Outlet was added!");
        }//if

    }//ADD OUTLET

    //2.1.2 MODIFY OUTLET
    public static void Modify_Outlet() throws Exception{

        OutletManager.displayAllRows();

        int outlet_number = InputHelper.getIntegerInput("Select a Outlet Number to update: ");

        Outlet bean = OutletManager.getRow(outlet_number);
        if (bean == null){
            System.err.println("No rows were found");
            return;
        }//if
        String address = InputHelper.getInput("Enter a new Outlet Address: ");
        bean.setAddress(address);
        String city = InputHelper.getInput("Enter a new Outlet City: ");
        bean.setCity(city);
        String state = InputHelper.getInput("Enter a new Outlet State: ");
        bean.setState(state);
        int zip = InputHelper.getIntegerInput("Enter a new Outlet Zip Code: ");
        bean.setZip(zip);
        String phone = InputHelper.getInput("Enter a new Outlet Phone: ");
        bean.setPhone(phone);


        if (OutletManager.update(bean)){
            System.out.println("Success!");
        }//if
        else {
            System.err.println("Try Again!");
        }//else

    }//MODIFY OUTLET

    //2.1.3 DELETE OUTLET
    public static void Delete_Outlet() throws Exception{

        OutletManager.displayAllRows();

        int outlet_number = InputHelper.getIntegerInput("Select a Outlet Number to delete: ");

        if (OutletManager.delete(outlet_number)){
            System.out.println("Success!");
        }//if
        else {
            System.err.println("Try Again!");
        }//else

    }//DELETE OUTLET

    //2.2.1 ADD EMPLOYEE
    public static void Add_Employee() throws Exception {

        EmployeeManager.displayAllRows();

        Employee bean = new Employee();
        bean.setOutlet_number(InputHelper.getIntegerInput("Outlet Number: "));
        bean.setEmp_number(InputHelper.getIntegerInput("Employee Number: "));
        bean.setEmp_name(InputHelper.getInput("Employee Name: "));

        boolean result = EmployeeManager.insert(bean);
        if (result){
            System.out.println("New Employee was added!");
        }//if

    }//ADD EMPLOYEE

    //2.2.2 MODIFY EMPLOYEE
    public static void Modify_Employee() throws Exception{

        EmployeeManager.displayAllRows();

        int outlet_number = InputHelper.getIntegerInput("Select a Outlet Number to update: ");

        Employee bean = EmployeeManager.getRow(outlet_number);
        if (bean == null){
            System.err.println("No rows were found");
            return;
        }//if
        int emp_number = InputHelper.getIntegerInput("Enter a new Employee Number: ");
        bean.setEmp_number(emp_number);
        String emp_name = InputHelper.getInput("Enter a new Employee Name: ");
        bean.setEmp_name(emp_name);

        if (EmployeeManager.update(bean)){
            System.out.println("Success!");
        }//if
        else {
            System.err.println("Try Again!");
        }//else

    }//MODIFY EMPLOYEE

    //2.2.3 DELETE EMPLOYEE
    public static void Delete_Employee() throws Exception{

        EmployeeManager.displayAllRows();

        int outlet_number = InputHelper.getIntegerInput("Select a Outlet Number to delete: ");

        if (EmployeeManager.delete(outlet_number)){
            System.out.println("Success!");
        }//if
        else {
            System.err.println("Try Again!");
        }//else

    }//DELETE EMPLOYEE

    //2.3.1 ADD CUSTOMER
    public static void Add_Customer() throws Exception {

        CustomerManager.displayAllRows();

        Customer bean = new Customer();
        bean.setCustomer_id(InputHelper.getIntegerInput("Customer Id:"));
        bean.setCustomer_name(InputHelper.getInput("Customer Name"));
        bean.setAddress(InputHelper.getInput("Adress: "));
        bean.setCity(InputHelper.getInput("City: "));
        bean.setState(InputHelper.getInput("State: "));
        bean.setZip(InputHelper.getIntegerInput("Zip: "));
        bean.setPhone(InputHelper.getInput("Phone: "));

        boolean result = CustomerManager.insert(bean);
        if (result){
            System.out.println("New Customer was added!");
        }//if
    }//ADD CUSTOMER

    //2.3.2 MODIFY CUSTOMER
    public static void Modify_Customer() throws Exception{

        CustomerManager.displayAllRows();

        int customer_id = InputHelper.getIntegerInput("Select a Customer ID to update: ");

        Customer bean = CustomerManager.getRow(customer_id);
        if (bean == null){
            System.err.println("No rows were found");
            return;
        }//if
        String customer_name = InputHelper.getInput("Enter a new Customer Name: ");
        bean.setCustomer_name(customer_name);
        String address = InputHelper.getInput("Enter a new Customer Address: ");
        bean.setAddress(address);
        String city = InputHelper.getInput("Enter a new Customer City: ");
        bean.setCity(city);
        String state = InputHelper.getInput("Enter a new Customer State: ");
        bean.setState(state);
        int zip = InputHelper.getIntegerInput("Enter a new Customer Zip Code: ");
        bean.setZip(zip);
        String phone = InputHelper.getInput("Enter a new Customer Phone: ");
        bean.setPhone(phone);

        if (CustomerManager.update(bean)){
            System.out.println("Success!");
        }//if
        else {
            System.err.println("Try Again!");
        }//else

    }//MODIFY CUSTOMER

    //2.3.3 DELETE CUSTOMER
    public static void Delete_Customer() throws Exception{

        CustomerManager.displayAllRows();

        int customer_id = InputHelper.getIntegerInput("Select a Customer ID to delete: ");

        if (CustomerManager.delete(customer_id)){
            System.out.println("Success!");
        }//if
        else {
            System.err.println("Try Again!");
        }//else

    }//DELETE CUSTOMER

    //2.4.1 ADD PRODUCT
    public static void Add_Product() throws Exception {
        ProductManager.displayAllRows();

        Product bean = new Product();
        bean.setOutlet_number(InputHelper.getIntegerInput("Outlet number: "));
        bean.setProduct_code(InputHelper.getIntegerInput("Product Code: "));
        bean.setArtist(InputHelper.getInput("Artist: "));
        bean.setTitle(InputHelper.getInput("Title: "));
        bean.setCost(InputHelper.getIntegerInput("Cost: "));
        bean.setSale_price(InputHelper.getIntegerInput("Sale price: "));
        boolean result = ProductManager.insert(bean);
        if (result){
            System.out.println("New Product was added!");
        }//if

    }//ADD PRODUCT

    //2.4.2 MODIFY PRODUCT
    public static void Modify_Product() throws Exception{

        ProductManager.displayAllRows();

        int product_code = InputHelper.getIntegerInput("Select a Product Code to update: ");

        Product bean = ProductManager.getRow(product_code);
        if (bean == null){
            System.err.println("No rows were found");
            return;
        }//if
        int outlet_number = InputHelper.getIntegerInput("Enter a new Outlet Number");
        bean.setOutlet_number(outlet_number);
        String artist = InputHelper.getInput("Enter a new Artist Name: ");
        bean.setArtist(artist);
        String title = InputHelper.getInput("Enter a new Title Name: ");
        bean.setTitle(title);
        int cost = InputHelper.getIntegerInput("Enter a new Cost Name: ");
        bean.setCost(cost);
        int sale_price = InputHelper.getIntegerInput("Enter a new Sale Price Name: ");
        bean.setSale_price(sale_price);

        if (ProductManager.update(bean)){
            System.out.println("Success!");
        }//if
        else {
            System.err.println("Try Again!");
        }//else

    }//MODIFY PRODUCT

    //2.4.3 DELETE PRODUCT
    public static void Delete_Product() throws Exception{

        ProductManager.displayAllRows();

        int product_code = InputHelper.getIntegerInput("Select a Customer ID to delete: ");

        if (ProductManager.delete(product_code)){
            System.out.println("Success!");
        }//if
        else {
            System.err.println("Try Again!");
        }//else

    }//DELETE PRODUCT

    //2.5.1 ADD SHIPMENT OUTLET
    public static void Add_Shipment_Outlet() throws Exception {

        InventoryManager.displayAllRows();

        Inventory bean = new Inventory();
        bean.setOutlet_number(InputHelper.getIntegerInput("Outlet Number: "));
        bean.setProduct_code(InputHelper.getIntegerInput("Product code: "));
        bean.setQuantity(InputHelper.getIntegerInput("Quantity: "));
        boolean result = InventoryManager.insert(bean);
        if (result){
            System.out.println("New product were added!");
        }//if

    }//ADD OUTLET

    //2.6 PROCESS A RETURN
    public static void  process_returns2 () throws SQLException {

        System.out.println("PLEASE COMPLETE THE NEXT INFORMATION: ");

        Returns bean = new Returns();
        bean.setOutlet_number(InputHelper.getIntegerInput("Outlet Number: "));
        bean.setProduct_code(InputHelper.getIntegerInput("Product Code:"));
        bean.setCustomer_id(InputHelper.getIntegerInput("Customer ID:"));
        bean.setReturn_time(InputHelper.getIntegerInput("Return Time:"));
        bean.setProduct_code(InputHelper.getIntegerInput("Quantity: "));
        bean.setQuantity(InputHelper.getIntegerInput("Reason: "));

        boolean result = ReturnsManager.process_return(bean);
        if (result){
            System.out.println("Thank you!");
        }//if

    }//PROCESS RETURNS

    //3.1 YEARLY REPORT
    public static void  yearly_report () throws SQLException{
        String sql = "SELECT * FROM sales";

        int customer_id = InputHelper.getIntegerInput("ENTER THE YEAR: ");

        Sales bean = Report_YearManager.getRow(customer_id);
        if(bean == null){
            System.err.println("No year was found");
        }//if
        else{
            try (
                    Connection conn = DBUtil.getConnection(DBType.MYSQL);
                    Statement stmt = conn.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = stmt.executeQuery(sql);
            ) {
                Report_YearManager.displaySelectedRows(rs);}
            catch (SQLException e){

                DBUtil.processException(e);
            }//catch

        }//else
    }//yearly_report
    //3.1 YEARLY REPORT

    //3.2 REPORT EMPLOYEE
    public static void  report_employee () throws SQLException {
        String sql = " SELECT emp_name, total.emp_number, sales FROM " +
                "(SELECT emp_number, SUM(quantity) sales FROM sales GROUP BY emp_number ORDER BY sales DESC) total " +
                " INNER JOIN employee ON total.emp_number = employee.emp_number " +
                " ORDER BY total.sales DESC ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            Report_EmployeeManager.displaySelectedRows(rs);}
        catch (SQLException e){

            DBUtil.processException(e);
        }//catch
    }//REPORT EMPLOYEE

    //3.3 TOP 10 ITEMS
    public static void  top_ten () throws SQLException {
        String sql = "SELECT title, t1.product_code, total FROM (SELECT product_code, SUM(quantity) total " +
                "FROM sales GROUP BY product_code ORDER BY total DESC) t1  " +
                "INNER JOIN product ON t1.product_code = product.product_code ORDER BY t1.total DESC";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            Top_10_items_Manager.displaySelectedRows(rs);}
        catch (SQLException e){

            DBUtil.processException(e);
        }//catch

    }//TOP 10 ITEMS


}//outlet