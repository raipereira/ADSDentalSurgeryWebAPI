package CS489.miu.citylibrarywebapi.service.impl;

import CS489.miu.citylibrarywebapi.dto.response.AddressPatientResponse;
import CS489.miu.citylibrarywebapi.model.Address;
import CS489.miu.citylibrarywebapi.repository.AddressRepository;
import CS489.miu.citylibrarywebapi.repository.PatientRepository;
import CS489.miu.citylibrarywebapi.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository repo;
    private ModelMapper modelMapper;
    private PatientRepository patientRepository;

    public AddressServiceImpl(AddressRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
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
    public List<AddressPatientResponse> findAll() {
        return converToDTOList(repo.findAll());
    }
    @Override
    public List<AddressPatientResponse> findAllWithPatient() {
        //var address = repo.findAllAddressesWithPatientsSortedByCity();

        return converToDTOList(repo.findAllAddressesWithPatientsSortedByCity());
    }

    private List<AddressPatientResponse> converToDTOList(List<Address> addresses){
        return addresses.stream().map(address ->
                modelMapper.map(address, AddressPatientResponse.class)).toList();
    }
}
