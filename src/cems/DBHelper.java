/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cems;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    public static boolean usernameExists(String username) {
        String sql = "SELECT 1 FROM users WHERE username = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Username already exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean emailExists(String email) {
        String sql = "SELECT 1 FROM users WHERE email = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Email already exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
    
    //get events
    public static ResultSet getAllEvents() {
        String sql = "SELECT event_no, event_name, event_type, location, date_start, date_end, participants FROM events";
        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean registerUserToEvent(String username, int eventNo) {
        String selectSql = "SELECT participants FROM events WHERE event_no = ?";
        String updateSql = "UPDATE events SET participants = ?, registered = 'true' WHERE event_no = ?";

        try (Connection conn = connect();
             PreparedStatement selectPs = conn.prepareStatement(selectSql);
             PreparedStatement updatePs = conn.prepareStatement(updateSql)) {

            selectPs.setInt(1, eventNo);
            ResultSet rs = selectPs.executeQuery();

            if (rs.next()) {
                String participants = rs.getString("participants");
                List<String> participantList = new ArrayList<>();

                if (participants != null && !participants.trim().isEmpty()) {
                    participantList = new ArrayList<>(Arrays.asList(participants.split(",")));
                }

                if (participantList.contains(username)) {
                    return false; // already registered
                }

                participantList.add(username);
                String updatedParticipants = String.join(",", participantList);

                updatePs.setString(1, updatedParticipants);
                updatePs.setInt(2, eventNo);

                return updatePs.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public static boolean insertEvent(String name, String type, String location, Timestamp dateStart, Timestamp dateEnd) {
        String sql = "INSERT INTO events (event_no, event_name, event_type, location, date_start, date_end) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int availableEventNo = getAvailableEventNo(); // get next reusable event_no

            ps.setInt(1, availableEventNo);
            ps.setString(2, name);
            ps.setString(3, type);
            ps.setString(4, location);
            ps.setTimestamp(5, dateStart);
            ps.setTimestamp(6, dateEnd);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static int getAvailableEventNo() {
        String sql = "SELECT event_no FROM events ORDER BY event_no";
        try (Connection conn = connect(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            int expected = 1;
            while (rs.next()) {
                int current = rs.getInt("event_no");
                if (current != expected) {
                    return expected;  // Gap found
                }
                expected++;
            }
            return expected;  // No gaps, return next number
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;  // Default to 1 if query fails
        }
    }
    
    public static boolean deleteEvent(int eventNo) {
        String sql = "DELETE FROM events WHERE event_no = ?";

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, eventNo);
            return ps.executeUpdate() > 0; // Returns true if a row was deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateEvent(int eventNo, String name, String type, String location, Timestamp dateStart, Timestamp dateEnd) {
        String sql = "UPDATE events SET event_name = ?, event_type = ?, location = ?, date_start = ?, date_end = ? WHERE event_no = ?";

        try (Connection conn = connect(); // Establish connection
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the parameters for the query
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setString(3, location);
            ps.setTimestamp(4, dateStart);
            ps.setTimestamp(5, dateEnd);
            ps.setInt(6, eventNo); // Use the event number as the identifier

            // Execute the update query
            return ps.executeUpdate() > 0; // Returns true if one or more rows were updated
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if the update failed
        }
    }
}
