package org.example.applicitacionesserver.Services;

import org.example.applicitacionesserver.Interfaces.IClients;
import org.example.applicitacionesserver.Models.ClientsDTO;
import org.example.applicitacionesserver.Repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientsServices implements IClients {
    @Autowired
    private ClientsRepository service;

    ClientsServices(ClientsRepository repository){
        this.service = repository;
    }

    @Override
    public ClientsDTO CreateClient(ClientsDTO information) {
        try{
            if (information != null) {
                information.set_id(UUID.randomUUID().toString());
                service.save(information);
                return information;
            }else{
                return null;
            }

        }catch (Exception error){
            throw error;
        }
    }

    @Override
    public List<ClientsDTO> GetALlClients() {
        return service.findAll();
    }

    @Override
    public ClientsDTO UpdateClient(ClientsDTO update) {
        try{
            if (update != null) {
                service.findById(update.get_id());
                service.save(update);
                return update;

            }else{
                return null;
            }


        }catch (Exception error){
            throw error;
        }
    }
    @Override
    public String DeleteClientSelected(String currentId) {
        if (currentId != null) {
            service.deleteById(currentId);

            return "CLIENTE CON ID"+currentId+"ELIMINADO";
        }else{
            return "ID INVALIDO O DATA INEXISTENTE";

        }
    }
}
