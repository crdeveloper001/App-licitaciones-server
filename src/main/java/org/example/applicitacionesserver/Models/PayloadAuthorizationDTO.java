package org.example.applicitacionesserver.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class PayloadAuthorizationDTO {
    
    public PayloadAuthorizationDTO() {
        
    }
    private String Auth_Key;
    private UsersDTO payload;
}
