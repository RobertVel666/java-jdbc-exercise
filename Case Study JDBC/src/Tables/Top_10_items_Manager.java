package Tables;

import beans.Returns;
import util.DBType;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Top_10_items_Manager {
    public static void displaySelectedRows(ResultSet rs) throws SQLException {
            while (rs.next()) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("Title: " + rs.getString("title") + " ");
                buffer.append("Product Code: " + rs.getInt("product_code") + " ");
                buffer.append("Total: " + rs.getInt("total"));

                System.out.println(buffer.toString());

            }//while


    }//displayData
}//Top_10_items_Manager
