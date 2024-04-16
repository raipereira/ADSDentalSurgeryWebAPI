package CS489.miu.citylibrarywebapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
public class AddressPatientResponse {
        private String city;
        private String state;
        private String zipCode;
        @JsonManagedReference
        private PatientAddressResponse patient;

}
