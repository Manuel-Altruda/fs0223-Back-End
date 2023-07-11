package com.giorno2.classes;

import java.sql.Date;

public class Student {
	
	private int id;
    private String name;
    private String lastname;
    private String gender;
    private Date birthdate;
    private float avg;
    private int minVote;
    private int maxVote;

    public Student(int id, String name, String lastname, String gender, Date birthdate, float avg, int minVote, int maxVote) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.avg = avg;
        this.minVote = minVote;
        this.maxVote = maxVote;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public String getGender() { return gender; }
    public Date getBirthdate() { return birthdate; }
    public float getAvg() { return avg; }
    public int getMinVote() { return minVote; }
    public int getMaxVote() { return maxVote; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                ", avg=" + avg +
                ", minVote=" + minVote +
                ", maxVote=" + maxVote +
                '}';
    }

}
