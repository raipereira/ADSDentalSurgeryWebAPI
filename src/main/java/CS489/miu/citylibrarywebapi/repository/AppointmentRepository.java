package CS489.miu.citylibrarywebapi.repository;

import CS489.miu.citylibrarywebapi.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
