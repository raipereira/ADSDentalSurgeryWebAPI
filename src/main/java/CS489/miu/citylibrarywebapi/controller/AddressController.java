package CS489.miu.citylibrarywebapi.controller;

import CS489.miu.citylibrarywebapi.dto.AddressPatientResponse;
import CS489.miu.citylibrarywebapi.dto.AddressResponse;
import CS489.miu.citylibrarywebapi.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/addresses")
public class AddressController {

    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AddressPatientResponse>> getAll(){
       // return ResponseEntity.ok(service.findAll());
        return ResponseEntity.ok(service.findAllWithPatient());
    }
}