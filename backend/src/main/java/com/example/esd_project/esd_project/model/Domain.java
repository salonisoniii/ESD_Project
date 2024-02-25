package com.example.esd_project.esd_project.model;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Domain {
    @Id
    @Column(name="domain_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="program",nullable = false)
    private String program;
    @Column(name="batch",nullable = false)
    private String batch;
    @Column(name="capicity",nullable = false)
    private int capicity;
    @Column(name="qualification")
    private String qualification;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getCapicity() {
        return capicity;
    }

    public void setCapicity(int capicity) {
        this.capicity = capicity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    //Constructors
    public Domain(Long id, String program, String batch, int capicity, String qualification) {
        this.id = id;
        this.program = program;
        this.batch = batch;
        this.capicity = capicity;
        this.qualification = qualification;
    }

    public Domain() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain domain = (Domain) o;
        return Objects.equals(getProgram(), domain.getProgram()) &&
                Objects.equals(getCapicity(), domain.getCapicity()) &&
                Objects.equals(getBatch(), domain.batch)&&
                Objects.equals(getQualification(), domain.getQualification()); // Add other fields as needed
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProgram(),getBatch(),getCapicity(),getQualification()); // Add other fields as needed
    }
}
