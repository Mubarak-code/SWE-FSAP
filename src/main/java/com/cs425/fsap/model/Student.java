package com.cs425.fsap.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long studentId;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String studentNumber;
    @NotBlank
    @Column(nullable = false)
    private String fullName;
    private Long phoneNumber;
    @NotBlank
    @Column(nullable = false)
    private String emailAddress;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAdmission;
    private Double cgpa;
    @ManyToOne
    @JoinTable(name="faculty_advisor")
    private Faculty advisor;

    public Student(){

    }

    public Student(Long studentId, @NotBlank String studentNumber, @NotBlank String fullName, Long phoneNumber, @NotBlank String emailAddress, LocalDate dateOfAdmission, Double cgpa, Faculty advisor) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.dateOfAdmission = dateOfAdmission;
        this.cgpa = cgpa;
        this.advisor = advisor;
        this.studentId = studentId;
    }

    public Student(@NotBlank String studentNumber, @NotBlank String fullName, Long phoneNumber, @NotBlank String emailAddress, @NotBlank LocalDate dateOfAdmission, Double cgpa) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.dateOfAdmission = dateOfAdmission;
        this.cgpa = cgpa;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Faculty getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Faculty advisor) {
        this.advisor = advisor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateOfAdmission=" + dateOfAdmission +
                ", cgpa=" + cgpa +
                ", advisor=" + advisor +
                '}';
    }
}
