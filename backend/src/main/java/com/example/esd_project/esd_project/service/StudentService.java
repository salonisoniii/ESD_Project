package com.example.esd_project.esd_project.service;
import com.example.esd_project.esd_project.model.Domain;
import com.example.esd_project.esd_project.model.Student;
import com.example.esd_project.esd_project.repository.DomainRepository;
import com.example.esd_project.esd_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DomainRepository domainRepository;

    private Student student;

        public void saveStudent(Student studentData) {
            try {
                String programName = studentData.getDomain().getProgram();
                Domain domainFromRequest=studentData.getDomain();
                Optional <Domain> domain = domainRepository.findByProgram(programName);
                if (domain.isPresent()){
                    Domain domainFromDatabase = domain.get();
                    if(Objects.equals(domainFromRequest,domainFromDatabase)) {
                        // If they are equal, set the domain from the database to the student data
                        studentData.setDomain(domainFromDatabase);
                        studentRepository.save(studentData);
                    } else {
                        // Handle the case where the domain objects are not equal
                        throw new RuntimeException("Domain not found");
                    }
                }
                else {
                    // Handle the case where the domain with the given ID is not found
                    throw new RuntimeException("Domain not found");
                }
            }
            catch (Exception e) {
                // Log the exception or throw a custom exception with a meaningful message
                e.printStackTrace();
                throw new RuntimeException("Failed to save student: " + e.getMessage());
            }
        }
    public List<Student> getStudentByDomain(Long domain) {
        return studentRepository.findByDomainId(domain);

    }
}