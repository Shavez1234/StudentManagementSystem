package com.StudentManagementSystem.Application.Repository;

import com.StudentManagementSystem.Application.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
