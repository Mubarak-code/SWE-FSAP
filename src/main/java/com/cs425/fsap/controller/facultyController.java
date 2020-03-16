package com.cs425.fsap.controller;

import com.cs425.fsap.model.Faculty;
import com.cs425.fsap.model.Student;
import com.cs425.fsap.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class facultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/allfaculty")
    public ModelAndView getAllFaculty(){
        List<Faculty> allFaculty = facultyService.allFaculty();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allfaculty", allFaculty );
        modelAndView.setViewName("faculty/facultylist");

        return modelAndView;

    }
}
