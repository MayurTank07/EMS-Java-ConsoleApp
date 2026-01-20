package in.ems.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBLogin {

    public static boolean checkLogin(String username, String password) {

        boolean isValid = false;

        try {
            Connection conn = DbConnection.getConnection();

            if (conn == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            String sql = "SELECT * FROM registration WHERE username = ? AND password = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isValid = true; // user found
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isValid;
    }
    
    public static boolean addEmployee(int empId, String name, double salary, String address, String company) {

        boolean isInserted = false;

        try {
            Connection conn = DbConnection.getConnection();

            if (conn == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            String sql = "INSERT INTO employee (emp_id, emp_name, salary, address, company) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.setString(2, name);
            ps.setDouble(3, salary);
            ps.setString(4, address);
            ps.setString(5, company);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                isInserted = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isInserted;
    }
    
    public static boolean updateEmployee(int empId, String name, double salary, String address, String company) {

        boolean isUpdated = false;

        try {
            Connection conn = DbConnection.getConnection();

            if (conn == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            String sql = "UPDATE employee SET emp_name = ?, salary = ?, address = ?, company = ? WHERE emp_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, address);
            ps.setString(4, company);
            ps.setInt(5, empId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                isUpdated = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    public static boolean deleteEmployee(int empId) {

        boolean isDeleted = false;

        try {
            Connection conn = DbConnection.getConnection();

            if (conn == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            String sql = "DELETE FROM employee WHERE emp_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, empId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                isDeleted = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isDeleted;
    }

    public static void viewEmployees() {

        try {
            Connection conn = DbConnection.getConnection();

            if (conn == null) {
                System.out.println("Database connection failed!");
                return;
            }

            String sql = "SELECT emp_id, emp_name, salary, address, company FROM employee";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n---------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-10s %-20s %-15s%n",
                    "EMP ID", "NAME", "SALARY", "ADDRESS", "COMPANY");
            System.out.println("---------------------------------------------------------------");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;

                System.out.printf("%-10d %-20s %-10.2f %-20s %-15s%n",
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getDouble("salary"),
                        rs.getString("address"),
                        rs.getString("company"));
            }

            if (!hasData) {
                System.out.println("\n\t No employees found ❌");
            }

            System.out.println("---------------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
