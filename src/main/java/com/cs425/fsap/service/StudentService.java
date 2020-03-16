package com.cs425.fsap.service;

import com.cs425.fsap.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> allStudent();
    void newStudent(Student student);
}
