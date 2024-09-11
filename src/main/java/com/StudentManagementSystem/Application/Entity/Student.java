package com.StudentManagementSystem.Application.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int studentid;

    @Getter @Setter
    private String studentname;

    @Getter @Setter
    private String subject;

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", studentname='" + studentname + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
