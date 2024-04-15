package CS489.miu.citylibrarywebapi.service.impl;

import CS489.miu.citylibrarywebapi.model.Surgery;
import CS489.miu.citylibrarywebapi.repository.SurgeryRepository;
import CS489.miu.citylibrarywebapi.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    private SurgeryRepository repo;

    public SurgeryServiceImpl(SurgeryRepository repo) {
        this.repo = repo;
    }

    @Override
    public void registerAll(List<Surgery> surgeries) {
        repo.saveAll(surgeries);
    }

    @Override
    public Surgery registerOne(Surgery surgery) {
        return repo.save(surgery);
    }
}
