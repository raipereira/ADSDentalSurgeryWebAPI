package CS489.miu.citylibrarywebapi.dto.request;

import CS489.miu.citylibrarywebapi.model.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class AddressResponse{
        private String city;
        private String state;
        private String zipCode;
        //@JsonBackReference
        //private PatientResponse patient;

}
