package CS489.miu.citylibrarywebapi.service.impl;

import CS489.miu.citylibrarywebapi.model.Dentist;
import CS489.miu.citylibrarywebapi.repository.DentistRepository;
import CS489.miu.citylibrarywebapi.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    private DentistRepository repo;

    public DentistServiceImpl(DentistRepository repo) {
        this.repo = repo;
    }

    @Override
    public Dentist registerOne(Dentist dentist) {
        return repo.save(dentist);
    }

    @Override
    public void registerAll(List<Dentist> dentists) {
        repo.saveAll(dentists);
    }
}
