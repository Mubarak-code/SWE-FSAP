package com.cs425.fsap.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facultyId;
    @NotBlank
    @Column(nullable = false)
    private String fullName;
    private Long phoneNumber;
    @NotBlank
    @Column(nullable = false)
    private String emailAddress;
    private String officeLocation;
    @OneToMany(mappedBy = "advisor")
    List<Student> students;

    public Faculty(){

    }

    public Faculty(@NotBlank String fullName, Long phoneNumber, @NotBlank String emailAddress, String officeLocation, List<Student> students) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.officeLocation = officeLocation;
        this.students = students;
    }

    public Faculty(@NotBlank String fullName, Long phoneNumber, @NotBlank String emailAddress, String officeLocation) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.officeLocation = officeLocation;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
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

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", officeLocation='" + officeLocation + '\'' +
                '}';
    }
}
