/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cems;

import java.sql.*;

/**
 *
 * @author whelz
 */
public class DBHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/cemsDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Insert user
    public static boolean insertUser(String studentID, String name, String username, String email, String gender, String role, String password) {
        if (role.equalsIgnoreCase("Student") || role.equalsIgnoreCase("Faculty Staff") || role.equalsIgnoreCase("Admin")) {
            if (studentID == null || studentID.trim().isEmpty()) {
                System.out.println("Student ID is required for role: " + role);
                return false;
            }

            if (studentIDExists(studentID)) {
                System.out.println("Student ID already exists: " + studentID);
                return false;
            }
        }

        String sql = "INSERT INTO users (student_id, name, username, email, gender, role, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, studentID);
            ps.setString(2, name);
            ps.setString(3, username);
            ps.setString(4, email);
            ps.setString(5, gender);
            ps.setString(6, role);
            ps.setString(7, password);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Get user role
    public static String getUserRole(String username, String password) {
        String sql = "SELECT role FROM users WHERE username = ? AND password = ?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Invalid login
    }

    //Get all users
    public static ResultSet getAllUsers() {
        String sql = "SELECT student_id, name, username, email, gender, role FROM users";
        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeQuery(); // return result set directly
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Get all users except a specific username
    public static ResultSet getAllUsersExcept(String excludedUsername) {
        String sql = "SELECT student_id, name, username, email, gender, role FROM users WHERE username <> ?";
        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, excludedUsername);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //check if a student ID exists
    public static boolean studentIDExists(String studentID) {
        String sql = "SELECT student_id FROM users WHERE student_id = ?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, studentID);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true if a row is returned
        } catch (SQLException e) {
            e.printStackTrace();
            return true; // assume exists on error to be safe
        }
    }
    
    //delete user
    public static boolean deleteUser(String studentID) {
        String sql = "DELETE FROM users WHERE student_id = ?";

        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, studentID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
