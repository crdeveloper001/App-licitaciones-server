package org.example.applicitacionesserver.Repositories;

import org.example.applicitacionesserver.Models.ClientsDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends MongoRepository<ClientsDTO,String> {
}
