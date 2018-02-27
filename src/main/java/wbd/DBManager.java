package wbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 * Created by Błażej on 2018-01-20.
 */
public class DBManager {
    private static Logger LOGGER = Logger.getLogger(DBManager.class.getName());
    private Connection connection;
    private String dataBase;
    private String user;
    private String password;

    DBManager(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }
        catch (ClassNotFoundException e){
            System.out.println("handled1");
        }
        catch (InstantiationException e){
            System.out.println("handled2");
        }
        catch (IllegalAccessException e) {
            System.out.println("handled3");
        }
    }

    public boolean init(String db, String userName, String pass){
        dataBase = db;
        user = userName;
        password = pass;

        if(getConnection()==null)
            return false;

        return true;
    }

    public Connection getConnection(){
        try {
            if(connection == null || !connection.isValid(3))
                connection = DriverManager.getConnection(dataBase, user, password);
            return connection;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }
}
