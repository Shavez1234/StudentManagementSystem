package com.StudentManagementSystem.Application.Service;

import com.StudentManagementSystem.Application.Controller.Dto.StudentDTO;

public interface StudentService {
    public boolean saveTicket(StudentDTO student) throws Exception; // This method is returning a boolean
    String saveStudent(StudentDTO studentDTO) throws Exception; // This method should return a String but is implemented with a boolean return type
}

