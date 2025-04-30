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
    public static boolean insertUser(String name, String username, String email, String gender, String role, String password) {
        String sql = "INSERT INTO users (name, username, email, gender, role, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setString(5, role);
            ps.setString(6, password);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //get user role
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
    
    //get users
    public static ResultSet getAllUsers() {
        String sql = "SELECT id, name, username, email, gender, role FROM users";
        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeQuery(); // return result set directly
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //get users (execpt mode)
    public static ResultSet getAllUsersExcept(String excludedUsername) {
        String sql = "SELECT id, name, username, email, gender, role FROM users WHERE username <> ?";
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
}
