package org.example.applicitacionesserver.Repositories;

import org.example.applicitacionesserver.Models.UsersDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<UsersDTO,String> {
}
