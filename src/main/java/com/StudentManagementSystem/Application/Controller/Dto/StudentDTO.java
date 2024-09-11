package com.StudentManagementSystem.Application.Controller.Dto;

import lombok.Getter;
import lombok.Setter;

public class StudentDTO {

    @Getter @Setter
    private String studentname;

    @Getter @Setter
    private String studentsubject;

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentname='" + studentname + '\'' +
                ", studentsubject='" + studentsubject + '\'' +
                '}';
    }
}

