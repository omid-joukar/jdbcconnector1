import dbconfig.DbConnection;
import model.Customers;
import org.junit.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KPS on 7/15/2020.
 */
public class DbConnectionTest {
 public static DbConnection dbConnection;
 List<Customers> customers = new ArrayList<>();
 String sql = "insert into customers (customerNumber ,firstName ,lastName ,city ,phone ,addressLine ,state ,country ,postalCode) values (?,?,?,?,?,?,?,?,?)";
 @BeforeClass
    public static void beforeClass()
 {
     dbConnection = new DbConnection();
 }
 @Test
    public void openConnection() throws SQLException {
       dbConnection.openConnection();
 }
 @Test
 public void ss() throws SQLException {
        PreparedStatement statement = dbConnection.openConnection().prepareStatement(sql);
        statement.setLong(1,1l);
        statement.setString(2,"omid");
        statement.setString(3,"joukar");
        statement.setString(4,"esfahan");
        statement.setString(5,"0660543488");
        statement.setString(6,"Esfahan ");
        statement.setString(7,"Esfahan");
        statement.setString(8,"Iran");
        statement.setLong(9,1230);
        statement.executeUpdate();

        }

 @AfterClass
    public static void afterClass() throws SQLException {
        dbConnection.closeConnection();
 }
}