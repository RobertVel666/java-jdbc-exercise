package Tables;

import beans.Sales;
import util.DBType;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Report_YearManager {

    public static void displaySelectedRows(ResultSet rs ) throws SQLException {

        while (rs.next()) {
            StringBuffer bf = new StringBuffer();
            bf.append("Outlet number: " + rs.getInt("outlet_number") + " ");
            bf.append("Employee Number: " + rs.getInt("emp_number") + " ");
            bf.append("Customer id: " + rs.getInt("customer_id") + " ");
            bf.append("Product Code: " + rs.getInt("product_code") + " ");
            bf.append("Sale date: " + rs.getInt("sale_date") + " ");
            bf.append("Sale time: " + rs.getInt("sale_time") + " ");
            bf.append("Quantity: " + rs.getInt("quantity") + " ");
            System.out.println(bf.toString());
        }//while

    }//displayData

    public static Sales getRow (int sale_date) throws SQLException {
        String sql = "SELECT * FROM sales   WHERE YEAR(sale_date) = ? ";
        ResultSet rs = null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,sale_date);
            rs = stmt.executeQuery();

            if(rs.next()){
                Sales bean = new Sales();
                bean.setCustomer_id(sale_date);
                bean.setOutlet_number(rs.getInt("outlet_number"));
                bean.setEmp_number(rs.getInt("emp_number"));
                bean.setCustomer_id(rs.getInt("customer_id"));
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



}//Report_YearManager
