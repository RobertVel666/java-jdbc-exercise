package Tables;

import beans.Outlet;
import util.DBType;
import util.DBUtil;

import java.sql.*;

public class OutletManager {

    public static void displayAllRows() throws SQLException {
        String sql = " SELECT * FROM outlet";
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            System.out.println("Outlet Table: ");
            while (rs.next()){
                StringBuffer bf = new StringBuffer();
                bf.append("Outlet Number: " + rs.getInt("outlet_number") + " ");
                bf.append("Address: " + rs.getString("address") + " ");
                bf.append("City: " + rs.getString("city") + " ");
                bf.append("State: " + rs.getString("state") + " ");
                bf.append("Zip: " + rs.getInt("zip") + " ");
                bf.append("Phone: " + rs.getString("phone") + " ");
                System.out.println(bf.toString());
            }//while


        }
    }//displayData

    public static Outlet getRow(int outlet_number) throws SQLException{
        String sql = " SELECT * FROM outlet WHERE outlet_number = ?";
        ResultSet rs = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){

            stmt.setInt(1,outlet_number);
            rs = stmt.executeQuery();
            if(rs.next()){
                Outlet bean = new Outlet();
                bean.setOutlet_number(outlet_number);
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

    public static boolean insert(Outlet bean) throws SQLException {
        String sql = " INSERT into outlet (outlet_number, address, city, state, zip, phone) " +
                "VALUES(?, ?, ?, ?, ?, ?)";

        ResultSet keys = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ){
            stmt.setInt(1, bean.getOutlet_number());
            stmt.setString(2, bean.getAddress());
            stmt.setString(3, bean.getCity());
            stmt.setString(4, bean.getState());
            stmt.setInt(5,bean.getZip());
            stmt.setString(6,bean.getPhone());
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

    public static boolean update(Outlet bean) {
        String sql = "UPDATE outlet SET " +
                "address = ?, city = ?, state = ?, zip = ? , phone = ? " +
                "WHERE outlet_number = ? ";
        try (
            Connection conn = DBUtil.getConnection(DBType.MYSQL);
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){

            stmt.setString(1,bean.getAddress());
            stmt.setString(2,bean.getCity());
            stmt.setString(3,bean.getState());
            stmt.setInt(4,bean.getZip());
            stmt.setString(5,bean.getPhone());
            stmt.setInt(6,bean.getOutlet_number());

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
        String sql = "DELETE FROM outlet  WHERE outlet_number = ? ";
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


}//OutletManager
