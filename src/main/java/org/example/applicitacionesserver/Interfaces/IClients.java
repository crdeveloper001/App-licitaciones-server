package org.example.applicitacionesserver.Interfaces;

import org.example.applicitacionesserver.Models.ClientsDTO;

import java.util.List;

public interface IClients {
    ClientsDTO CreateClient(ClientsDTO information);
    List<ClientsDTO> GetALlClients();
    ClientsDTO UpdateClient(ClientsDTO update);
    String DeleteClientSelected(String currentId);


}
