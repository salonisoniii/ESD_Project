package com.example.esd_project.esd_project.repository;

import com.example.esd_project.esd_project.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DomainRepository extends JpaRepository<Domain,Long> {
    Optional<Domain> findByProgram(String program);

}
