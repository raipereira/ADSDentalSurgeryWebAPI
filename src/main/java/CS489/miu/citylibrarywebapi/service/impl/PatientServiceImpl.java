package CS489.miu.citylibrarywebapi.service.impl;

import CS489.miu.citylibrarywebapi.dto.PatientRequest;
import CS489.miu.citylibrarywebapi.dto.PatientResponse;
import CS489.miu.citylibrarywebapi.execption.NotElementFoundException;
import CS489.miu.citylibrarywebapi.model.Patient;
import CS489.miu.citylibrarywebapi.repository.PatientRepository;
import CS489.miu.citylibrarywebapi.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private ModelMapper modelMapper;
    private PatientRepository repo;

    public PatientServiceImpl(ModelMapper modelMapper, PatientRepository repo) {
        this.modelMapper = modelMapper;
        this.repo = repo;
    }


    @Override
    public void registerAll(List<Patient> patients) {
        repo.saveAll(patients);
    }

    @Override
    public Patient registerOne(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public List<PatientResponse> getAll() {
        var entities = repo.findAll();
//        var patientResponse = entities.stream().map(entity ->
//                modelMapper.map(entity, PatientResponse.class)).toList();
        return converToDtoList(entities);
    }

    @Override
    public PatientResponse getOne(Integer id) {
        var entity = repo.findById(id).orElseThrow(() -> new NotElementFoundException("Patient not found"));
        return convertToDto(entity);
    }

    @Override
    public PatientResponse register(PatientRequest request) {
        var entity = convertToEntity(request);
        entity.setAppointments(new ArrayList<>());
        entity = repo.save(entity);
        return convertToDto(entity);
    }

    @Override
    public PatientResponse update(PatientRequest patientRequest, Integer patientId) {
        var entity = repo.findById(patientId).orElseThrow(() -> new NotElementFoundException("Patient Not found"));
        modelMapper.map(patientRequest, entity);
        return convertToDto(entity);
    }

    @Override
    public void delete(Integer patientId) {
        repo.findById(patientId).orElseThrow(() -> new NotElementFoundException("Patient not found"));
        repo.deleteById(patientId);
    }

    @Override
    public List<PatientResponse> searchPatients(String searchString) {
        var patients = repo.searchPatients(searchString);
        return converToDtoList(patients);
    }

    private List<PatientResponse> converToDtoList(List<Patient> patients){
        return patients.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private  PatientResponse convertToDto(Patient patient) {
        return modelMapper.map(patient, PatientResponse.class);
    }
    private  Patient convertToEntity(PatientRequest patientResquest) {
        return modelMapper.map(patientResquest, Patient.class);
    }
}
