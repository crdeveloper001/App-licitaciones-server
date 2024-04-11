package org.example.applicitacionesserver.Controllers;

import org.example.applicitacionesserver.Models.TenderDTO;
import org.example.applicitacionesserver.Services.TenderServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/Tenders")
public class TenderController {

    private final TenderServices tenderServices;
    public TenderController(TenderServices service){
        this.tenderServices = service;
    }
    @GetMapping("/GetTenders")
    public ResponseEntity<?> GetAllTenders(){
        return new ResponseEntity<>(tenderServices.GetALlTenders(), HttpStatus.OK);

    }
    @PostMapping("/NewTender")
    public ResponseEntity<?> PostTender(@RequestBody TenderDTO information){

        if (information != null){
            tenderServices.CreateTender(information);
            return new ResponseEntity<String>("TENDER CREATED",HttpStatus.OK);

        }else{
            return new ResponseEntity<>("ERROR ON CREATED TENDER",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/UpdateTender")
    public ResponseEntity<?> PutTender(@RequestBody TenderDTO update){
        if(update != null){
            tenderServices.UpdateTenders(update);
            return new ResponseEntity<String>("TENDER UPDATED",HttpStatus.OK);

        }else{
            return new ResponseEntity<String>("ERROR ON UPDATED TENDER",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/DeleteTender/{id}")
    public ResponseEntity<?> DeleteTender(@PathVariable String id){
        if(id != null){
            tenderServices.DeleteTenderSelected(id);
            return new ResponseEntity<String>("TENDER DELETED",HttpStatus.OK);

        }else{
            return new ResponseEntity<String>("ERROR ON DELETE TENDER",HttpStatus.BAD_REQUEST);
        }
    }
}
