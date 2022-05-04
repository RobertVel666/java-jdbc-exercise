package Tables;

import beans.Sales;
import util.DBType;
import util.DBUtil;
import java.sql.*;

public class SalesManager {

    public static void displayAllRows() throws SQLException {
        String sql = "SELECT * FROM sales  ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            System.out.println("Sales Table: ");

            while (rs.next()) {
                StringBuffer bf = new StringBuffer();
                bf.append("Outlet number: " + rs.getInt("outlet_number") + ": ");
                bf.append("Employee number: " + rs.getInt("emp_number") + ": ");
                bf.append("Customer ID: " + rs.getInt("customer_id") + ": ");
                bf.append("Product code: " + rs.getInt("product_code") + ": ");
                bf.append("Sale date: " + rs.getDate("sale_date")+": ");
                bf.append("Sale time: " + rs.getTime("sale_time") + ": ");
                bf.append("Quantity: " + rs.getInt("quantity")+": ");
                System.out.println(bf.toString());
            }//while
        }
    }//displayData

    public static Sales getRow (int customer_id) throws SQLException {
        String sql = "SELECT * FROM sales WHERE customer_id = ?";
        ResultSet rs = null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1,customer_id);
            rs = stmt.executeQuery();

            if(rs.next()){
                Sales bean = new Sales();
                bean.setCustomer_id(customer_id);
                bean.setOutlet_number(rs.getInt("outlet_number"));
                bean.setEmp_number(rs.getInt("emp_number"));
                bean.setProduct_code(rs.getInt("product_code"));
                bean.setSale_date(rs.getInt("sale_date"));
                bean.setSale_time(rs.getInt("sale_time"));
                bean.setQuantity(rs.getInt("quantity"));
                return bean;
            }//if
            else {
                return null;
            }//else
        }
        catch (SQLException e){
            System.err.println(e);
        } finally {
            if (rs != null) rs.close();
        }
        return null;
    }//getRow

    public static boolean process_sale(Sales bean) throws SQLException {
        String sql = " INSERT into sales (outlet_number, emp_number, customer_id, product_code,sale_date, sale_time, quantity) " +
                "VALUES( ?, ?, ?, ?, ?, ?, ?)";
        ResultSet keys = null;
        java.util.Date date=new java.util.Date();
        java.sql.Date Sale_Date=new java.sql.Date(date.getTime());
        java.sql.Time Sale_Time=new java.sql.Time(date.getTime());
        int Emp_number = 105;

        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setInt(1,bean.getOutlet_number());
            stmt.setInt(2,Emp_number);
            stmt.setInt(3,bean.getCustomer_id());
            stmt.setInt(4,bean.getProduct_code());
            stmt.setDate(5,Sale_Date);
            stmt.setTime(6,Sale_Time);
            stmt.setInt(7,bean.getQuantity());
            int affected = stmt.executeUpdate();

            if(affected ==1){
                keys = stmt.getGeneratedKeys();
                keys.next();
                int newKey = keys.getInt(1);
            } else{
                System.err.println("NO CHANGES MADE");
                return false;
            }
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            if (keys != null) keys.close();
        }
        return true;
    }//insert


}//Sales
