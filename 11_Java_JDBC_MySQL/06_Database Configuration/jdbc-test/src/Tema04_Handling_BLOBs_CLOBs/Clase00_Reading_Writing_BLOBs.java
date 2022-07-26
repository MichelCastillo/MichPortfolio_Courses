package Tema04_Handling_BLOBs_CLOBs;

import java.io.*;
import java.sql.*;

public class Clase00_Reading_Writing_BLOBs {

    //Reading BLOBs

    public static void main(String[] args) throws Exception {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        InputStream input = null;
        FileOutputStream output = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo", "student", "student");

            // 2. Execute statement
            myStmt = myConn.createStatement();
            String sql = "select resume from employees where email='john.doe@foo.com'";
            myRs = myStmt.executeQuery(sql);

            // 3. Set up a handle to the file
            File theFile = new File("resume_from_db.pdf");
            output = new FileOutputStream(theFile);

            if (myRs.next()) {

                input = myRs.getBinaryStream("resume");
                System.out.println("Reading resume from database...");
                System.out.println(sql);

                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }

                System.out.println("\nSaved to file: " + theFile.getAbsolutePath());

                System.out.println("\nCompleted successfully!");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }

            if (output != null) {
                output.close();
            }

            close(myConn, myStmt);
        }
    }

    private static void close(Connection myConn, Statement myStmt)
            throws SQLException {

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }

}

class WriteBlobDemo {

    public static void main(String[] args) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        FileInputStream input = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo", "student", "student");

            // 2. Prepare statement
            String sql = "update employees set resume=? where email='john.doe@foo.com'";
            myStmt = myConn.prepareStatement(sql);

            // 3. Set parameter for resume file name
            File theFile = new File("sample_resume.pdf");
            input = new FileInputStream(theFile);
            myStmt.setBinaryStream(1, input);

            System.out.println("Reading input file: " + theFile.getAbsolutePath());

            // 4. Execute statement
            System.out.println("\nStoring resume in database: " + theFile);
            System.out.println(sql);

            myStmt.executeUpdate();

            System.out.println("\nCompleted successfully!");

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }

            close(myConn, myStmt);
        }
    }

    private static void close(Connection myConn, Statement myStmt)
            throws SQLException {

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }

}
