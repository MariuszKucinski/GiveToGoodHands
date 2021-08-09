package pl.coderslab.charity.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepo;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {
    public final InstitutionRepo institutionRepo;

    @Autowired
    public InstitutionServiceImpl(InstitutionRepo institutionRepo) {
        this.institutionRepo = institutionRepo;
    }

    @Override
    public List<Institution> findAllInstitutions() {
        return institutionRepo.findAll();
    }
}
