package pl.hansonq.HotelManager.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lukasz on 2017-10-28.
 */
public class MsSqlConnetor {
    private static final String SQL_LINK = "jdbc:sqlserver://MYPC\\\\HOTELMANAGER;databaseName=hotelmanager";
    private static final String SQL_USER = "admin";
    private static final String SQL_PASS = "admin";
    private static final String SQL_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static MsSqlConnetor getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private MsSqlConnetor(){
connect();
    }
    private static class SingletonHolder {
        private static final MsSqlConnetor INSTANCE = new MsSqlConnetor();
    }
    private Connection connection;
    private Connection getConnection(){
        return  connection;
    }
    private void connect() {
        try {
            Class.forName(SQL_CLASS);
            connection = DriverManager.getConnection(SQL_LINK, SQL_USER, SQL_PASS);
            System.out.println("Połączenie udane!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
