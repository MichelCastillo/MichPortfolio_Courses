package Tema01_PerformingBasicJDBCOperations;

import java.sql.*;

public class Clase01_InsertingData_into_Database {

    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/demo";
        String user = "student";
        String pass = "student";

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");

            System.out.println("Database connection successful!\n");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Insert a new employee
            System.out.println("Inserting a new employeee to database\n");

            int rowsAffected = myStmt.executeUpdate(
                    "insert into employees (last_name, first_name, email, department, salary) " +
                            "values ('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)"
            );

            // 4. Verify this by getting a list of employees
            myRs = myStmt.executeQuery("select * from employees order by last_name");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
