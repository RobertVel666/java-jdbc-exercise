package Tables;

import beans.Customer;
import beans.Employee;
import beans.Outlet;
import util.DBType;
import util.DBUtil;

import java.sql.*;

public class CustomerManager {

    public static void displayAllRows() throws SQLException {
        String sql = " SELECT * FROM customer";
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            System.out.println("Customer Table: ");
            while (rs.next()){
                StringBuffer bf = new StringBuffer();
                bf.append("Customer Id: " + rs.getInt("customer_id") + " ");
                bf.append("Customer Name: " + rs.getString("customer_name") + " ");
                bf.append("Address: " + rs.getString("address") + " ");
                bf.append("City: " + rs.getString("city") + " ");
                bf.append("State: " + rs.getString("state") + " ");
                bf.append("Zip: " + rs.getInt("zip") + " ");
                bf.append("Phone: " + rs.getString("phone") + " ");
                System.out.println(bf.toString());
            }//while
        }
    }//displayData

    public static Customer getRow(int customer_id) throws SQLException{
        String sql = " SELECT * FROM customer WHERE customer_id = ?";
        ResultSet rs = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,customer_id);
            rs = stmt.executeQuery();
            if(rs.next()){
                Customer bean = new Customer();
                bean.setCustomer_id(rs.getInt("customer_id"));
                bean.setCustomer_name(rs.getString("customer_name"));
                bean.setAddress(rs.getString("address"));
                bean.setCity(rs.getString("city"));
                bean.setState(rs.getString("state"));
                bean.setZip(rs.getInt("zip"));
                bean.setPhone(rs.getString("phone"));
                return bean;
            }
            else{
                return null;
            }//else
        }
        catch (SQLException e){
            System.err.println(e);
            return null;
        }//catch
        finally {
            if(rs!=null) rs.close();
        }
    }//getRow

    public static boolean insert(Customer bean) throws SQLException {
        String sql = " INSERT into customer (customer_id, customer_name, address, city, state, zip, phone) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";

        ResultSet keys = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setInt(1, bean.getCustomer_id());
            stmt.setString(2, bean.getCustomer_name());
            stmt.setString(3, bean.getAddress());
            stmt.setString(4, bean.getCity());
            stmt.setString(5, bean.getState());
            stmt.setInt(6,bean.getZip());
            stmt.setString(7,bean.getPhone());
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

    public static boolean update(Customer bean) {
        String sql = "UPDATE customer SET " +
                "customer_name = ?, address = ?, city = ?, state = ?, zip = ? , phone = ? " +
                "WHERE customer_id = ? ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1,bean.getCustomer_name());
            stmt.setString(2,bean.getAddress());
            stmt.setString(3,bean.getCity());
            stmt.setString(4,bean.getState());
            stmt.setInt(5,bean.getZip());
            stmt.setString(6,bean.getPhone());
            stmt.setInt(7,bean.getCustomer_id());

            int affected = stmt.executeUpdate();
            if (affected == 1){
                return true;
            }//if
            else {
                return false;
            }//else
        }
        catch (SQLException e){
            System.err.println(e);
            return false;
        }//catch
    }//update

    public static boolean delete (int customer_id) {
        String sql = "DELETE FROM customer  WHERE customer_id = ? ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,customer_id);
            int affected = stmt.executeUpdate();

            if (affected == 1){
                return true;
            }//if
            else {
                return false;
            }//else
        }
        catch (SQLException e){
            System.err.println(e);
            return false;
        }//catch
    }//delete

}//CUSTOMER MANAGER
