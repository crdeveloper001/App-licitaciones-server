package org.example.applicitacionesserver.Controllers;

import org.example.applicitacionesserver.Models.ClientsDTO;
import org.example.applicitacionesserver.Services.ClientsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/Clients")
public class ClientsController {

    private final ClientsServices clientsServices;
    public ClientsController(ClientsServices service) {
        this.clientsServices = service;
    }
    @GetMapping("/GetAllClients")
    public ResponseEntity<?> GetClients(){

        return new ResponseEntity<>(clientsServices.GetALlClients(), HttpStatus.OK);
    }
    @PostMapping("/NewClient")
    public ResponseEntity<?> PostClient(@RequestBody ClientsDTO client){

        if (client != null) {
            clientsServices.CreateClient(client);
            return new ResponseEntity<String>("CLIENT CREATED",HttpStatus.OK);
        }else{

            return new ResponseEntity<String>("ERROR AL CREAR CLIENTE",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/UpdateClient")
    public ResponseEntity<?> PutClient(@RequestBody ClientsDTO update){

        if (update != null) {
            clientsServices.UpdateClient(update);
            return new ResponseEntity<String>("CLIENT UPDATED",HttpStatus.OK);

        }else{
            return new ResponseEntity<String>("ERROR AL ACTUALIZAR CLIENTE",HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("DeleteClient/{id}")
    public ResponseEntity<?> DeleteClient(@PathVariable String id){
        if(id != null){
            clientsServices.DeleteClientSelected(id);
            return new ResponseEntity<String>("CLIENT DELETED",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("ERROR AL ELIMINAR CLIENTE",HttpStatus.BAD_REQUEST);
        }
    }

}
