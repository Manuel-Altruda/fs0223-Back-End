package com.giorno2.classes;

import java.sql.*;
import java.util.HashMap;

public class SchoolStudents {
    private Connection conn;

    public SchoolStudents(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("DB Connect");
        
        String createTableSQL = "CREATE TABLE school_students IF NOT EXISTS("
                + "id SERIAL PRIMARY KEY,"
                + "name TEXT NOT NULL,"
                + "lastname TEXT NOT NULL,"
                + "gender CHAR(1) NOT NULL,"
                + "birthdate DATE NOT NULL,"
                + "avg DOUBLE PRECISION NOT NULL,"
                + "min_vote INTEGER NOT NULL,"
                + "max_vote INTEGER NOT NULL"
                + ")";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Tabella school_students creata con successo!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertStudent(Student s) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO school_students VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, s.getId());
        stmt.setString(2, s.getName());
        stmt.setString(3, s.getLastname());
        stmt.setString(4, s.getGender());
        stmt.setDate(5, new java.sql.Date(s.getBirthdate().getTime()));
        stmt.setFloat(6, s.getAvg());
        stmt.setInt(7, s.getMinVote());
        stmt.setInt(8, s.getMaxVote());
        //stmt.executeUpdate();
    }

    public void updateStudent(int id, HashMap<String, Object> s) throws SQLException {
        StringBuilder sb = new StringBuilder("UPDATE school_students SET ");
        for (String key : s.keySet()) {
            sb.append(key).append("=?, ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" WHERE id=?");
        PreparedStatement stmt = conn.prepareStatement(sb.toString());
        int i = 1;
        for (Object value : s.values()) {
            if (value instanceof String) {
                stmt.setString(i++, (String) value);
            } else if (value instanceof Date) {
                stmt.setDate(i++, new java.sql.Date(((Date) value).getTime()));
            } else if (value instanceof Double) {
                stmt.setDouble(i++, (Double) value);
            } else if (value instanceof Integer) {
                stmt.setInt(i++, (Integer) value);
            }
        }
        stmt.setInt(i++, id);
        try {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errore durante l'esecuzione dell'istruzione SQL: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM school_students WHERE id=?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public Student getBest() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM school_students ORDER BY avg DESC LIMIT 1");
        if (rs.next()) {
            return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("gender"), rs.getDate("birthdate"), rs.getFloat("avg"), rs.getInt("min_vote"), rs.getInt("max_vote"));
        } else {
            return null;
        }
    }

    public void getVoteRange(int min, int max) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM school_students WHERE min_vote >= ? AND max_vote <= ?");
        stmt.setInt(1, min);
        stmt.setInt(2, max);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("gender"), rs.getDate("birthdate"), rs.getFloat("avg"), rs.getInt("min_vote"), rs.getInt("max_vote")));
        }
    }
}
