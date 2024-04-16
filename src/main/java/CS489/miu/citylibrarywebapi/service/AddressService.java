package CS489.miu.citylibrarywebapi.service;


import CS489.miu.citylibrarywebapi.dto.response.AddressPatientResponse;
import CS489.miu.citylibrarywebapi.model.Address;

import java.util.List;

public interface AddressService {

    Address register(Address address);
     void registerAll(List<Address> addresses);
    List<AddressPatientResponse> findAll();

    List<AddressPatientResponse> findAllWithPatient();


}
