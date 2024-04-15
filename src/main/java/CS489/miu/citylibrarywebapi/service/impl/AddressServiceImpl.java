package CS489.miu.citylibrarywebapi.service.impl;

import CS489.miu.citylibrarywebapi.model.Address;
import CS489.miu.citylibrarywebapi.repository.AddressRepository;
import CS489.miu.citylibrarywebapi.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository repo;

    public AddressServiceImpl(AddressRepository repo) {
        this.repo = repo;
    }

    @Override
    public Address register(Address address) {
        return repo.save(address);
    }

    @Override
    public void registerAll(List<Address> addresses) {
        repo.saveAll(addresses);
    }


    @Override
    public List<Address> findAll() {
        return repo.findAll();
    }
}
