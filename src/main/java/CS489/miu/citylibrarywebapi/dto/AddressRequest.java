package CS489.miu.citylibrarywebapi.dto;

import lombok.Data;

@Data
public class AddressRequest {
        private String city;
        private String state;
        private String zipCode;

}
