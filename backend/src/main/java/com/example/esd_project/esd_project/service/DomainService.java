package com.example.esd_project.esd_project.service;
import com.example.esd_project.esd_project.model.Domain;
import com.example.esd_project.esd_project.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DomainService {

    @Autowired
    private DomainRepository domainRepository;

    private Domain domain;

    public void saveDomain(Domain domainData) {
        domainRepository.save(domainData);
    }

    public List<Domain> getAllDomains() {
        return domainRepository.findAll();
    }
    public Domain getDomainById(Long domainId) {
            return domainRepository.findById(domainId).orElse(null);
    }

    public void updateDomain(Long domainId, Domain updatedDomainData) {
        Domain existingDomain = domainRepository.findById(domainId).orElse(null);

        if (existingDomain != null) {
            // Update properties of the existing domain with the new data
            existingDomain.setProgram(updatedDomainData.getProgram());
            existingDomain.setBatch(updatedDomainData.getBatch());
            existingDomain.setCapicity(updatedDomainData.getCapicity());
            existingDomain.setQualification(updatedDomainData.getQualification());

            // Save the updated domain
            domainRepository.save(existingDomain);
        }
    }
}
