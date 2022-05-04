package Tables;

import beans.Sales;
import util.DBType;
import util.DBUtil;

import java.sql.*;

public class Report_EmployeeManager {
    public static void displaySelectedRows(ResultSet rs ) throws SQLException {

            while (rs.next()) {
                StringBuffer bf = new StringBuffer();
                bf.append("Employee Name: " + rs.getString("emp_name") + ": ");
                bf.append("Employee Number: " + rs.getInt("total.emp_number") + ": ");
                bf.append("Sales: " + rs.getInt("sales") + ": ");
                System.out.println(bf.toString());
            }//while

    }//displayData

    public static Sales getRow (int emp_number) throws SQLException {
        String sql = " SELECT emp_name, total.emp_number, sales FROM " +
                "(SELECT emp_number, SUM(quantity) sales FROM sales GROUP BY emp_number ORDER BY sales DESC) total " +
                " INNER JOIN employee ON total.emp_number = employee.emp_number " + "WHERE total.emp_number = ? " +
                " ORDER BY total.sales DESC ";
        ResultSet rs = null;
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,emp_number);
            rs = stmt.executeQuery();

            if(rs.next()){
                Sales bean = new Sales();
                bean.setCustomer_id(emp_number);
                bean.setOutlet_number(rs.getInt("emp_name"));
                bean.setEmp_number(rs.getInt("total.emp_number"));
                bean.setCustomer_id(rs.getInt("sales"));
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


}//Report_EmployeeManager
