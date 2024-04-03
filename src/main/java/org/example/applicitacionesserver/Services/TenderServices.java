package org.example.applicitacionesserver.Services;

import org.example.applicitacionesserver.Interfaces.ITender;
import org.example.applicitacionesserver.Models.TenderDTO;
import org.example.applicitacionesserver.Repositories.TenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TenderServices implements ITender {
    @Autowired
    private TenderRepository service;

    TenderServices(TenderRepository repository){
        this.service = repository;
    }
    @Override
    public TenderDTO CreateTender(TenderDTO information) {
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
    public List<TenderDTO> GetALlTenders() {
        return service.findAll();
    }

    @Override
    public TenderDTO UpdateTenders(TenderDTO update) {
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
    public String DeleteTenderSelected(String currentId) {
        if (currentId != null) {
            service.deleteById(currentId);

            return "CLIENTE CON ID"+currentId+"ELIMINADO";
        }else{
            return "ID INVALIDO O DATA INEXISTENTE";

        }
    }
}
