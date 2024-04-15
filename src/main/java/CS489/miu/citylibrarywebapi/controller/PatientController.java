package CS489.miu.citylibrarywebapi.controller;

import CS489.miu.citylibrarywebapi.dto.PatientRequest;
import CS489.miu.citylibrarywebapi.dto.PatientResponse;
import CS489.miu.citylibrarywebapi.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ={"/adsweb/api/v1/patients"})
public class PatientController {

    private PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<PatientResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{patientId}")
    public ResponseEntity<?> getOne(@PathVariable Integer patientId) {
        return ResponseEntity.ok(service.getOne(patientId));
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody PatientRequest request){
        var newPatient = service.register(request);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<?> update(@RequestBody PatientRequest patientRequest, @PathVariable Integer patientId) {
        return ResponseEntity.ok(service.update(patientRequest, patientId));
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> delete(@PathVariable Integer patientId){
        service.delete(patientId);
        return ResponseEntity.ok("Patient with ID " + patientId + " has been deleted successfully.");
    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<PatientResponse>> searchPatients(@PathVariable String searchString) {
        var patients = service.searchPatients(searchString);
        return ResponseEntity.ok(patients);
    }


}
