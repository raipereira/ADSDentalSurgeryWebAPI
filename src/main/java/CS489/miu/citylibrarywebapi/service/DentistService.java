package CS489.miu.citylibrarywebapi.service;


import CS489.miu.citylibrarywebapi.model.Dentist;

import java.util.List;

public interface DentistService {

    Dentist registerOne(Dentist dentist);

    void registerAll(List<Dentist> dentists);
}
