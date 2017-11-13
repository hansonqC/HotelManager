package pl.hansonq.HotelManager.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lukasz on 2017-10-28.
 */
public class FdbConnetor {
    private static final String SQL_LINK = "jdbc:firebirdsql://localhost:3050/C:\\Users\\lukasz\\Desktop\\HOTEL.FDB";
    private static final String SQL_USER = "SYSDBA";
    private static final String SQL_PASS = "Komornik123";
    private static final String SQL_CLASS = "org.firebirdsql.jdbc.FBDriver";

    public static FdbConnetor getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private FdbConnetor(){
connect();
    }
    private static class SingletonHolder {
        private static final FdbConnetor INSTANCE = new FdbConnetor();
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
