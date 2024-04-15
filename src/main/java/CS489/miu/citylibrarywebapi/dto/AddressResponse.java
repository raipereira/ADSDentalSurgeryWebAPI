package CS489.miu.citylibrarywebapi.dto;

import lombok.Data;

@Data
public class AddressResponse{
        private String city;
        private String state;
        private String zipCode;

}
