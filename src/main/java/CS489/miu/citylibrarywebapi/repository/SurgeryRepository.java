package CS489.miu.citylibrarywebapi.repository;

import CS489.miu.citylibrarywebapi.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
