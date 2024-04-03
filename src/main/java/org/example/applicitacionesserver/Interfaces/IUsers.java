package org.example.applicitacionesserver.Interfaces;

import org.example.applicitacionesserver.Models.TenderDTO;
import org.example.applicitacionesserver.Models.UsersDTO;

import java.util.List;

public interface IUsers {
    UsersDTO CreateUser(UsersDTO information) throws Exception;
    List<UsersDTO> GetAllUsers();
    UsersDTO UpdateUsers(UsersDTO update);
    String DeleteUserSelected(String currentId);
}
