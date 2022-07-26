package Tema01_PerformingBasicJDBCOperations;

import java.sql.*;

public class Clase04_CreatingPreparedStatements {

    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");

            // 2. Prepare Statement
            myStmt = myConn.prepareStatement("select * from employees where salary > ? and department=?");

            // 3. Set the paramenters
            myStmt.setDouble(1, 80000);
            myStmt.setString(2, "Legal");


            // 4. Execute SQL query
            myRs = myStmt.executeQuery();

            // 5. Display the resultSet
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }

}
