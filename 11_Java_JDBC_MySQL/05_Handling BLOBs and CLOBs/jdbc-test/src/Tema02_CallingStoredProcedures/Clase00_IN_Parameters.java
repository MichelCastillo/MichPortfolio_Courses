package Tema02_CallingStoredProcedures;

import java.sql.*;

public class Clase00_IN_Parameters {

    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        CallableStatement myStmt = null;

        try{

            // 1- Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");

            String theDepartment = "Engineering";
            int theIncreaseAmount = 10000;

            // 2- Show the salaries BEFORE
            System.out.println("SALARIES BEFORE...");
            showSalaries(myConn, theDepartment);

            // 3- Prepare the stored procedure call
            myStmt = myConn.prepareCall("{call increase_salaries_for_department(?, ?)}");

            // 4- Set the parameters
            myStmt.setString(1, theDepartment);
            myStmt.setDouble(2, theIncreaseAmount);

            // 5- Calling the SP
            myStmt.execute();

            // 5- Show the salaries AFTER
            System.out.println("SALARIES AFTER...");
            showSalaries(myConn, theDepartment);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(myConn, myStmt, null);
        }

    }

    private static void showSalaries(Connection myConn, String theDepartment) throws SQLException {
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // Prepare statement
            myStmt = myConn
                    .prepareStatement("select * from employees where department=?");

            myStmt.setString(1, theDepartment);

            // Execute SQL query
            myRs = myStmt.executeQuery();

            // Process result set
            while (myRs.next()) {
                String lastName = myRs.getString("last_name");
                String firstName = myRs.getString("first_name");
                double salary = myRs.getDouble("salary");
                String department = myRs.getString("department");

                System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            close(myStmt, myRs);
        }

    }

    private static void close(Connection myConn, Statement myStmt,
                              ResultSet myRs) throws SQLException {
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

    private static void close(Statement myStmt, ResultSet myRs)
            throws SQLException {

        close(null, myStmt, myRs);
    }
}
