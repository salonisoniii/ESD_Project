package com.example.esd_project.esd_project.repository;
import com.example.esd_project.esd_project.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface AdminRepository extends JpaRepository<Admin,Long> {
     Admin findByEmail(String email);
    Optional <Admin> findOneByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

}
