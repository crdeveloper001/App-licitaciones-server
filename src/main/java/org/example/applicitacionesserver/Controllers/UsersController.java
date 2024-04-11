package org.example.applicitacionesserver.Controllers;

import org.example.applicitacionesserver.Models.UsersDTO;
import org.example.applicitacionesserver.Services.UsersServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/Users")
public class UsersController {
    private final UsersServices usersServices;
    public UsersController(UsersServices services) {
        this.usersServices = services;
    }
    @GetMapping("/GetAllUsers")
    public ResponseEntity<?> GetClients(){

        return new ResponseEntity<>(usersServices.GetAllUsers(), HttpStatus.OK);
    }
    @PostMapping("/NewUser")
    public ResponseEntity<?> PostClient(@RequestBody UsersDTO user){

        if (user != null) {
            usersServices.CreateUser(user);
            return new ResponseEntity<String>("USER CREATED",HttpStatus.OK);
        }else{

            return new ResponseEntity<String>("ERROR AL CREAR USUARIO",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/UpdateUser")
    public ResponseEntity<?> PutClient(@RequestBody UsersDTO update){

        if (update != null) {
            usersServices.UpdateUsers(update);
            return new ResponseEntity<String>("USER UPDATED",HttpStatus.OK);

        }else{
            return new ResponseEntity<String>("ERROR AL ACTUALIZAR USUARIO",HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("DeleteUser/{id}")
    public ResponseEntity<?> DeleteClient(@PathVariable String id){
        if(id != null){
            usersServices.DeleteUserSelected(id);
            return new ResponseEntity<String>("USER DELETED",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("ERROR AL ELIMINAR USUARIO",HttpStatus.BAD_REQUEST);
        }
    }

}
