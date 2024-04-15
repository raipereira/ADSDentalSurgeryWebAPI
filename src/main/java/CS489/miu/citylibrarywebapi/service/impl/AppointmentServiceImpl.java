package CS489.miu.citylibrarywebapi.service.impl;

import CS489.miu.citylibrarywebapi.model.Appointment;
import CS489.miu.citylibrarywebapi.repository.AppointmentRepository;
import CS489.miu.citylibrarywebapi.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository repo;

    public AppointmentServiceImpl(AppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void registerAll(List<Appointment> appointments) {
        repo.saveAll(appointments);
    }

    @Override
    public List<Appointment> getAll() {
        return repo.findAll();
    }

}
