package com.jvolima.treinamentocati.entities;

import com.jvolima.treinamentocati.entities.enums.StudentShift;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private StudentShift shift;

    @Column(nullable = false)
    private Integer yearOfEntry;

    @Column(nullable = false)
    private Integer ira;

    public Student() {
    }

    public Student(Integer id, String fullName, String course, StudentShift shift, Integer yearOfEntry, Integer ira) {
        this.id = id;
        this.fullName = fullName;
        this.course = course;
        this.shift = shift;
        this.yearOfEntry = yearOfEntry;
        this.ira = ira;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public StudentShift getShift() {
        return shift;
    }

    public void setShift(StudentShift shift) {
        this.shift = shift;
    }

    public Integer getYearOfEntry() {
        return yearOfEntry;
    }

    public void setYearOfEntry(Integer yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public Integer getIra() {
        return ira;
    }

    public void setIra(Integer ira) {
        this.ira = ira;
    }
}
