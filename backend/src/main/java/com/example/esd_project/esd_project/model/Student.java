package com.example.esd_project.esd_project.model;
import jakarta.persistence.*;

@Entity
@Table(name= "student")
public class Student {
    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="roll_number",nullable = false,unique = true)
    private int roll_number;

    @Column(name="first_name",nullable = false)
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="photograph_path")
    private String photograph_path;

    @Column(name="cgpa",nullable = false,columnDefinition = "float default 0.0")
    private float cgpa;

    @Column(name="total_credits",nullable = false)
    private float total_credits;

    @Column(name="graduation_year")
    private int graduation_year;

    @ManyToOne
    @JoinColumn(name = "domain")
    private Domain domain;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(int roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public float getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(float total_credits) {
        this.total_credits = total_credits;
    }

    public int getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(int graduation_year) {
        this.graduation_year = graduation_year;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    //Constructor

    public Student(Long id, int roll_number, String first_name, String last_name, String email, String photograph_path, float cgpa, float total_credits, int graduation_year, Domain domain) {
        this.id = id;
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.photograph_path = photograph_path;
        this.cgpa = cgpa;
        this.total_credits = total_credits;
        this.graduation_year = graduation_year;
        this.domain = domain;
    }

    public Student() {
    }

}
