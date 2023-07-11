package com.giorno2.main;
import java.sql.*;
import java.util.HashMap;

import com.giorno2.classes.SchoolStudents;
import com.giorno2.classes.Student;

public class Main {

	public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/SchoolDB";
        String user = "postgres";
        String password = "root";

        SchoolStudents ss = new SchoolStudents(url, user, password);

        Student s1 = new Student(1, "Mario", "Rossi", "M", Date.valueOf("2005-01-01"), 7.5f, 6, 9);
        Student s2 = new Student(2, "Luigi", "Verdi", "M", Date.valueOf("2005-02-01"), 8.0f, 7, 10);
        Student s3 = new Student(3, "Giuseppe", "Bianchi", "M", Date.valueOf("2005-03-01"), 6.5f, 5, 8);

        ss.insertStudent(s1);
        ss.insertStudent(s2);
        ss.insertStudent(s3);

        HashMap<String, Object> updateMap = new HashMap<>();
        updateMap.put("name", "Giovanni");
        updateMap.put("lastname", "Neri");
        updateMap.put("avg", 8.5f);
        ss.updateStudent(1, updateMap);

        ss.deleteStudent(3);

        System.out.println(ss.getBest());

        ss.getVoteRange(6, 9);
    }

}
