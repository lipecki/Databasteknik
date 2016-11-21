package mainTests;

import com.Connector;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    private static String enteredPassword;

    public static void main(String[] args) {

        Connection connection = null;
        try {
            Connector c = new Connector();
            connection = c.getConnection();
            if(connection != null){
                System.out.println("Connection established");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(connection != null){
                try{
                    connection.close();
                }
                catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            }
        }

    }
}
