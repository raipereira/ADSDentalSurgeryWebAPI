package CS489.miu.citylibrarywebapi.service;

import CS489.miu.citylibrarywebapi.model.Appointment;

import java.util.List;

public interface AppointmentService {

    void registerAll(List<Appointment> appointments);

    List<Appointment> getAll();
}
