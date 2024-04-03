package org.example.applicitacionesserver.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Data
@Getter
@Setter
@AllArgsConstructor

@Document("Clients")
public class ClientsDTO {
    @Id
    private String _id;
    private String client_name;
    private String client_email;
    private String client_phone;
    private String client_website;
    private boolean client_state;

}
