package com.cs425.fsap.controller;

import com.cs425.fsap.model.Faculty;
import com.cs425.fsap.model.Student;
import com.cs425.fsap.service.FacultyService;
import com.cs425.fsap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/allstudents")
    public ModelAndView allStudents(){
        List<Student> allStudents = studentService.allStudent();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", allStudents);
        modelAndView.setViewName("student/studentlist");

        return modelAndView;

    }

    @GetMapping("/newstudentform")
    public ModelAndView newStudent(Model model){
        List<Faculty> allFacutly = facultyService.allFaculty();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newStudent", new Student());
        modelAndView.addObject("Faculty",allFacutly);
        modelAndView.setViewName("student/newstudentform");

        return modelAndView;

    }

    @PostMapping("/newstudent")
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult result){
        if(result.hasErrors())
            return "redirect:/newstudentform";
        studentService.newStudent(student);

        return "redirect:/allstudents";


    }
}
