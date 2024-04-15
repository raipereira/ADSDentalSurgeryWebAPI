package CS489.miu.citylibrarywebapi.repository;

import CS489.miu.citylibrarywebapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
