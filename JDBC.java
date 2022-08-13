package JDBC;

import java.sql.Connection; //import to referenced libraries
import java.sql.DriverManager; //does connection to the database (converts code)
import java.sql.ResultSet; //grabs result off your query
import java.sql.SQLException; //where the error throws goes
import java.sql.Statement; //statement to the SQL server

public class JDBC {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/University"; //no outside access //this is part of your mysql setup, if working with remote database, you will need to get the line from whoever set up the database so that you know what to call
        String uname = "root";
        String password = "Leafhouse1"; //a more complicated password is suggested
        String query = "select * from EngineeringStudents"; //use in our code to start off with

        //test, did we import our package correctly?

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //do we have the driver for this?
        } catch (ClassNotFoundException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();

        }
        try {
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement statement = con.createStatement(); //based on driver manager, which is connected to our connection, initiating instance
            ResultSet result = statement.executeQuery(query); //storing the pipeline to bring the data in

            while(result.next()){  //generates a boolean "hey there is another result coming in, we need to get that next result"
                String UniversityData = "";
                for (int i = 1; i <= 6; i++){ //loop through the different results
                    UniversityData += result.getString(i) + ":"; //each of these rows, we have an array of strings //getString of column "i"
                }
                System.out.println(UniversityData);

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
