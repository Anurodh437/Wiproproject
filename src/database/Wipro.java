package database;
import java.sql.*;

public class Wipro {
    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/wiprodata";
        String userName = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
        Statement result = connection.createStatement();
        //for executing select statement we use resultset to fetch each and every rows and columns.
        ResultSet resultSet = result.executeQuery("select * from CANDIDATE_TBL");
    }
}











