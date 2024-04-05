package org.example.applicitacionesserver.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.example.applicitacionesserver.Models.AuthorizationDTO;
import org.example.applicitacionesserver.Models.PayloadAuthorizationDTO;
import org.example.applicitacionesserver.Models.UsersDTO;
import org.example.applicitacionesserver.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/Authorization")
public class AuthorizationController {
    @Autowired
    private UsersRepository service;

    public AuthorizationController(UsersRepository usersRepository) {
        this.service = usersRepository;
    }

    @PostMapping("/LoginCredential")
    public ResponseEntity<?> postLoginCredential(@RequestBody AuthorizationDTO credentials) throws Exception {

        try {
            List<UsersDTO> currentUsers = service.findAll();
            PayloadAuthorizationDTO payload = new PayloadAuthorizationDTO();

            for (UsersDTO usersDTO : currentUsers) {
                if (usersDTO.getUser_email().equals(credentials.getEmail())
                        && usersDTO.getUser_password().equals(credentials.getPass())) {
                    usersDTO.setUser_password(null);
                    payload.setPayload(usersDTO);
                    payload.setAuth_Key("ADMIN_USER");
                    return new ResponseEntity<PayloadAuthorizationDTO>(payload, HttpStatus.OK);
                } else {
                    return new ResponseEntity<String>("USUARIO INCORRECTO O NO ENCONTRADO", HttpStatus.NOT_FOUND);
                }
            }

        } catch (Exception e) {
            throw e;
        }
        return null;

    }

}
