package Tables;

import beans.Employee;
import beans.Outlet;
import util.DBType;
import util.DBUtil;

import java.sql.*;

public class EmployeeManager {

    public static void displayAllRows() throws SQLException {
        String sql = " SELECT * FROM employee";
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            System.out.println("Employee Table: ");
            while (rs.next()){
                StringBuffer bf = new StringBuffer();
                bf.append("Outlet Number: " + rs.getInt("outlet_number") + " ");
                bf.append("Employee Number: " + rs.getString("emp_number") + " ");
                bf.append("Employee Name: " + rs.getString("emp_name") + " ");
                System.out.println(bf.toString());
            }//while
        }
    }//displayData

    public static Employee getRow(int outlet_number) throws SQLException{
        String sql = " SELECT * FROM employee WHERE outlet_number = ?";
        ResultSet rs = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,outlet_number);
            rs = stmt.executeQuery();
            if(rs.next()){
                Employee bean = new Employee();
                bean.setOutlet_number(outlet_number);
                bean.setEmp_number(rs.getInt("emp_number"));
                bean.setEmp_name(rs.getString("emp_name"));

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

    public static boolean insert(Employee bean) throws SQLException {
        String sql = " INSERT into employee (outlet_number, emp_number, emp_name) " +
                "VALUES(?, ?, ?)";

        ResultSet keys = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setInt(1,bean.getOutlet_number());
            stmt.setInt(2,bean.getEmp_number());
            stmt.setString(3,bean.getEmp_name());


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

    public static boolean update(Employee bean) {
        String sql = "UPDATE employee SET " +
                "emp_number = ?, emp_name = ? " +
                "WHERE outlet_number = ? ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,bean.getEmp_number());
            stmt.setString(2,bean.getEmp_name());
            stmt.setInt(3,bean.getOutlet_number());

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

    public static boolean delete (int outlet_number) {
        String sql = "DELETE FROM employee  WHERE outlet_number = ? ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,outlet_number);
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


}//EmployeeManager
