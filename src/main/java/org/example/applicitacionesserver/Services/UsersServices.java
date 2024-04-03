package org.example.applicitacionesserver.Services;

import org.apache.catalina.User;
import org.example.applicitacionesserver.Interfaces.IUsers;
import org.example.applicitacionesserver.Models.UsersDTO;
import org.example.applicitacionesserver.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersServices implements IUsers {

    @Autowired
    private UsersRepository service;

    UsersServices(UsersRepository repository){
        this.service = repository;
    }

    @Override
    public UsersDTO CreateUser(UsersDTO information) {

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
    public List<UsersDTO> GetAllUsers() {
        return service.findAll();
    }

    @Override
    public UsersDTO UpdateUsers(UsersDTO update) {

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
    public String DeleteUserSelected(String currentId) {

        if (currentId != null) {
            service.deleteById(currentId);

            return "USUARIO CON ID"+currentId+"ELIMINADO";
        }else{
            return "ID INVALIDO O DATA INEXISTENTE";

        }
    }
}
