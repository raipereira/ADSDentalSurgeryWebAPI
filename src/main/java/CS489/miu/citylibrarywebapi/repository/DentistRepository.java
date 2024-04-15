package CS489.miu.citylibrarywebapi.repository;

import CS489.miu.citylibrarywebapi.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
