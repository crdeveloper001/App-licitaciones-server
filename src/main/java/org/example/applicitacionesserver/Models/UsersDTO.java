package org.example.applicitacionesserver.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@AllArgsConstructor

@Document("Users")
public class UsersDTO {
    @Id
    private String _id;
    private String user_name;
    private String user_lastname;
    private String user_email;
    private String user_department;
    private String user_manager;
    private String user_account;
    private String user_password;



}
