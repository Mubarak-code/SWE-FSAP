package com.cs425.fsap.service;

import com.cs425.fsap.model.Faculty;
import com.cs425.fsap.model.Student;
import com.cs425.fsap.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class FacultyServiceImpl implements  FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> allFaculty() {
        List<Faculty> allFaculty = facultyRepository.findAll();
//        students.sort(Comparator.comparing(Student:: getFullName));
        allFaculty.sort(Comparator.comparing(Faculty :: getFullName).reversed());
        return allFaculty;
    }
}
