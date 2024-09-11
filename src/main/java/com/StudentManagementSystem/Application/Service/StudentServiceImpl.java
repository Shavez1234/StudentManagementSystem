package com.StudentManagementSystem.Application.Service;

import com.StudentManagementSystem.Application.Controller.Dto.StudentDTO;
import com.StudentManagementSystem.Application.Entity.Student;
import com.StudentManagementSystem.Application.Exception.StudentNameNotValidException;
import com.StudentManagementSystem.Application.Exception.SubjectNotValidException;
import com.StudentManagementSystem.Application.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public String saveStudent(StudentDTO studentDTO) throws Exception {
        // Validate name
        boolean isValidName = isNameValid(studentDTO.getStudentname());
        if (!isValidName) throw new StudentNameNotValidException("Enter a valid name!");

        // Validate subject
        boolean isValidSubject = isSubjectValid(studentDTO.getStudentsubject());
        if (!isValidSubject) throw new SubjectNotValidException("Enter a valid subject!");

        // Convert DTO to Entity
        Student studentEntity = DTOToEntity(studentDTO);

        // Save the student entity to the database
        repository.save(studentEntity);

        // Return a success message with the student ID
        return "Student saved successfully with ID: " + studentEntity.getStudentid();
    }

    @Override
    public boolean saveTicket(StudentDTO student) throws Exception {
        // Convert DTO to Entity
        Student studentEntity = DTOToEntity(student);

        // Validate and save the student entity
        if (isNameValid(student.getStudentname()) && isSubjectValid(student.getStudentsubject())) {
            repository.save(studentEntity);
            return true; // Success
        } else {
            throw new Exception("Invalid student data");
        }
    }

    private boolean isNameValid(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubjectValid(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            return false;
        }
        for (char c : subject.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    private Student DTOToEntity(StudentDTO dto) {
        Student studentEntity = new Student();
        studentEntity.setStudentname(dto.getStudentname());
        studentEntity.setSubject(dto.getStudentsubject());
        return studentEntity;
    }
}
