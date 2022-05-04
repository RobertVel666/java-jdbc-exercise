package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static util.DBType.*;

public class DBUtil {

    private static  final String USERNAME = "dbuser";
    private static  final String PASSWORD = "dbpassword";
    private static final String M_CONN_STRING =
            "jdbc:mysql://localhost/outlet";

    public static Connection getConnection(DBType dbType) throws SQLException {

        switch (dbType){
            case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING, USERNAME,PASSWORD);
            default:
                return  null;
        }//switch

    }//connection

    public static void processException(SQLException e){
        System.err.println("Error message" + e.getMessage());
        System.err.println("Error code:" + e.getErrorCode());
        System.err.println("SQL state:" + e.getSQLState());
    }

}//class
