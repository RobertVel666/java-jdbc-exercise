package Tables;

import beans.Customer;
import beans.Inventory;
import util.DBType;
import util.DBUtil;

import java.sql.*;

public class InventoryManager {
    public static void displayAllRows() throws SQLException {
        String sql = " SELECT * FROM inventory";
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            System.out.println("Inventory Table: ");
            while (rs.next()){
                StringBuffer bf = new StringBuffer();
                bf.append("Outlet Number: " + rs.getInt("outlet_number") + " ");
                bf.append("Product Code: " + rs.getString("product_code") + " ");
                bf.append("Quantity: " + rs.getString("quantity") + " ");
                System.out.println(bf.toString());
            }//while
        }
    }//displayData

    public static Inventory getRow(int customer_id) throws SQLException{
        String sql = " SELECT * FROM inventory WHERE outlet_number = ?";
        ResultSet rs = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,customer_id);
            rs = stmt.executeQuery();
            if(rs.next()){
                Inventory bean = new Inventory();
                bean.setOutlet_number(rs.getInt("outlet_number"));
                bean.setProduct_code(rs.getInt("customer_name"));
                bean.setQuantity(rs.getInt("quantity"));
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

    public static boolean insert(Inventory bean) throws SQLException {
        String sql = " INSERT into inventory (outlet_number, product_code, quantity) " +
                "VALUES( ?, ?, ? )";

        ResultSet keys = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setInt(1, bean.getOutlet_number());
            stmt.setInt(2,bean.getProduct_code());
            stmt.setInt(3,bean.getQuantity());
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


}//InventoryManager
