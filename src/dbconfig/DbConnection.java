package dbconfig;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by KPS on 7/29/2020.
 */
public class DbConnection {
    private Connection connection;
    private Properties properties;
    private static final Logger LOGGER = Logger.getLogger(DbConnection.class.getName());
    public DbConnection( ) {
        this.properties = new Properties();
        try {
            InputStream stream = this.getClass().getResource("/setting.txt").openStream();
            properties.load(stream);
            Class.forName(properties.getProperty("db-drive"));
            LOGGER.info("The properties is good installed");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection openConnection(){
        try {
            this.connection = DriverManager.getConnection(properties.getProperty("db-url"),
                    properties.getProperty("db-user"),
                    properties.getProperty("db-password"));
            LOGGER.info("The connection is established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public Connection getConnection(){
        return connection;
    }
    public void closeConnection(){
        if (this.connection!=null){
            try {
                connection.close();
                LOGGER.info("The connection is closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
