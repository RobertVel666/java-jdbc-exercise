package Tables;
import beans.Returns;
import util.DBType;
import util.DBUtil;
import java.sql.*;


public class ReturnsManager {

    public static void displayAllRows() throws SQLException {
        String sql = "SELECT * FROM returns";
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            System.out.println("Returns Table: ");
            while (rs.next()) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("Outlet number:" + rs.getInt("outlet_number"));
                buffer.append("Product code: " + rs.getInt("product_code") + ": ");
                buffer.append("Customer ID: " + rs.getInt("customer_id") + ": ");
                buffer.append("Return Date: " + rs.getInt("return_date")+": ");
                buffer.append("Return Time: " + rs.getInt("return_time") + ": ");
                buffer.append("Quantity: " + rs.getInt("quantity")+": ");
                buffer.append("Product code: " + rs.getString("reason") + ": ");
                System.out.println(buffer.toString());
            }//while
        }
    }//displayData

    public static Returns getRow (int customer_id) throws SQLException {
        String sql = "SELECT * FROM returns WHERE customer_id = ?";
        ResultSet rs = null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,customer_id);
            rs = stmt.executeQuery();

            if(rs.next()){
                Returns bean = new Returns();
                bean.setCustomer_id(customer_id);
                bean.setOutlet_number(rs.getInt("outlet_number"));
                bean.setProduct_code(rs.getInt("product_code"));
                bean.setReturn_time(rs.getInt("return_date"));
                bean.setReturn_time(rs.getInt("return_time"));
                bean.setQuantity(rs.getInt("quantity"));
                bean.setReason(rs.getString("reason"));
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

    public static boolean process_return(Returns bean) throws SQLException {
        String sql = "INSERT into returns (outlet_number, product_code, customer_id, return_date, return_time, " +
                "quantity, reason) " +
                "VALUES( ?, ?, ?, ?, ?,?,?)";
        ResultSet keys = null;
        java.util.Date date=new java.util.Date();
        java.sql.Date Return_Date=new java.sql.Date(date.getTime());
        int return_time = 15;

        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setInt(1,bean.getOutlet_number());
            stmt.setInt(2,bean.getProduct_code());
            stmt.setInt(3,bean.getCustomer_id());
            stmt.setDate(4,Return_Date);
            stmt.setInt(5,return_time);
            stmt.setInt(6,bean.getQuantity());
            stmt.setString(7,bean.getReason());
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
    public static boolean process_returns(Returns bean) throws SQLException {
        String sql = "INSERT into returns (outlet_number, product_code, customer_id, return_date, return_time, " +
                "quantity, reason) " +
                "VALUES( ?, ?, ?, ?, ?,?,?)";
        ResultSet keys = null;
        java.util.Date date=new java.util.Date();
        java.sql.Date Return_Date=new java.sql.Date(date.getTime());

        try(
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setInt(1,bean.getOutlet_number());
            stmt.setInt(2,bean.getProduct_code());
            stmt.setInt(3,bean.getCustomer_id());
            stmt.setDate(4,Return_Date);
            stmt.setInt(5,bean.getReturn_time());
            stmt.setInt(6,bean.getQuantity());
            stmt.setString(7,bean.getReason());
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






}//Returns
