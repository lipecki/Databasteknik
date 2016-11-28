package main;

import com.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Main {

    private static String enteredPassword;
    private static Statement stmt;

    private static PreparedStatement pstmt;         // ser till att inget SQL-injection kan pervertera databasen

    public static void main(String[] args) throws Exception{

        Connection connection = null;
        try {
            Connector c = new Connector();
            connection = c.getConnection();
            if(connection != null){
                System.out.println("Connection established\n");

                stmt = connection.createStatement();

                ResultSet RS = stmt.executeQuery("SELECT * FROM T_Customer");

                while (RS.next()){
                    System.out.println(RS.getString("last_name"));
                }
                System.out.println(RS.getMetaData());

                pstmt = connection.prepareStatement("SELECT * FROM T_Loan");
            }
            //connection.commit();                              //!! Om du behöver transaktioner!!
        }
        catch (Exception e){
            e.printStackTrace();
            //if(connection != null) connection.rollback();    //!! Om du behöver transaktioner!!
            throw e;
        }
        finally{
            if(connection != null){
                try{
                    stmt.close();       //!!
                    pstmt.close();
                    connection.close();
                }
                catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            }
        }

    }
}
