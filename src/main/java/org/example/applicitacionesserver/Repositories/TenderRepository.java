package org.example.applicitacionesserver.Repositories;

import org.example.applicitacionesserver.Models.ClientsDTO;
import org.example.applicitacionesserver.Models.TenderDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderRepository extends MongoRepository<TenderDTO,String> {
}
