package CS489.miu.citylibrarywebapi.service;

import CS489.miu.citylibrarywebapi.model.Surgery;

import java.util.List;

public interface SurgeryService {

    void registerAll(List<Surgery> surgeries);

    Surgery registerOne(Surgery surgery);
}
