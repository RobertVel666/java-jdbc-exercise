package Tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    public static void displayData(ResultSet rs) throws SQLException {
        while (rs.next()) {
            StringBuffer buffer = new StringBuffer();

            buffer.append("Outlet Number:" + " " +rs.getInt("outlet_number" )+ " ");
            buffer.append("Product Code:" + " " +rs.getInt("product_code")+ " ");
            buffer.append("Artist:" + " " +rs.getInt("artist")+ " ");
            buffer.append("Title:" + " " +rs.getInt("title")+ " ");
            buffer.append("Sale Price:" + " " +rs.getInt("sale_price")+ " ");
            System.out.println(buffer.toString());
        }//while
    }//displayData
}//Product
