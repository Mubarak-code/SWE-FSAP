package com.cs425.fsap.service;

import com.cs425.fsap.model.Student;
import com.cs425.fsap.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> allStudent() {
        List<Student> students = studentRepository.findAll();
        students.sort(Comparator.comparing(Student :: getFullName));
        return  students;
    }

    @Override
    public void newStudent(Student student) {
        studentRepository.save(student);

    }
}
