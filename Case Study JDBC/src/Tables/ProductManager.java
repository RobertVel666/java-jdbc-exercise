package Tables;

import beans.Customer;
import beans.Product;
import util.DBType;
import util.DBUtil;

import java.sql.*;

public class ProductManager {

    public static void displayAllRows() throws SQLException {
        String sql = " SELECT * FROM product";
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            System.out.println("Product Table: ");
            while (rs.next()){
                StringBuffer bf = new StringBuffer();
                bf.append("Outlet Number: "+ rs.getInt("outlet_number") + " ");
                bf.append("Product Code: " + rs.getInt("product_code") + " ");
                bf.append("Artist: " + rs.getString("artist") + " ");
                bf.append("Title: " + rs.getString("title") + " ");
                bf.append("Cost: " + rs.getString("cost") + " ");
                bf.append("Sale Price: " + rs.getInt("sale_price") + " ");
                System.out.println(bf.toString());
            }//while
        }
    }//displayData

    public static void displaysalesRows() throws SQLException {
        String sql = " SELECT outlet_number, product_code, artist, title, sale_price FROM product";
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            System.out.println("Product Table: ");
            while (rs.next()){
                StringBuffer bf = new StringBuffer();
                bf.append("Outlet Number: "+ rs.getInt("outlet_number") + " ");
                bf.append("Product Code: " + rs.getInt("product_code") + " ");
                bf.append("Artist: " + rs.getString("artist") + " ");
                bf.append("Title: " + rs.getString("title") + " ");
                bf.append("Sale Price: " + rs.getInt("sale_price") + " ");
                System.out.println(bf.toString());
            }//while
        }
    }//displayData

    public static Product getRow(int product_code) throws SQLException{
        String sql = " SELECT * FROM product WHERE product_code = ?";
        ResultSet rs = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,product_code);
            rs = stmt.executeQuery();
            if(rs.next()){
                Product bean = new Product();
                bean.setOutlet_number(rs.getInt("outlet_number"));
                bean.setProduct_code(rs.getInt("product_code"));
                bean.setArtist(rs.getString("artist"));
                bean.setTitle(rs.getString("title"));
                bean.setCost(rs.getInt("cost"));
                bean.setSale_price(rs.getInt("sale_price"));
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

    public static boolean insert(Product bean) throws SQLException {
        String sql = " INSERT into product (outlet_number, product_code, artist, title, cost, sale_price) " +
                "VALUES(? , ?, ?, ?, ?, ?)";

        ResultSet keys = null;
        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setInt(1,bean.getOutlet_number());
            stmt.setString(2, bean.getArtist());
            stmt.setString(3, bean.getTitle());
            stmt.setInt(4,bean.getCost());
            stmt.setInt(5,bean.getSale_price());
            stmt.setInt(6, bean.getProduct_code());
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

    public static boolean update(Product bean) {
        String sql = "UPDATE product SET " +
                " outlet_number = ? ,artist = ?, title = ?, cost = ?, sale_price = ? " +
                "WHERE product_code = ? ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,bean.getOutlet_number());
            stmt.setString(2,bean.getArtist());
            stmt.setString(3,bean.getTitle());
            stmt.setInt(4,bean.getCost());
            stmt.setInt(5,bean.getSale_price());
            stmt.setInt(6,bean.getProduct_code());

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

    public static boolean delete (int product_code) {
        String sql = "DELETE FROM customer  WHERE customer_id = ? ";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,product_code);
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

}//ProductManager
