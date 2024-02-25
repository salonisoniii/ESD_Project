package com.example.esd_project.esd_project.repository;

import com.example.esd_project.esd_project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByDomainId(Long domainId);
}
