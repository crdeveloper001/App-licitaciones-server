package org.example.applicitacionesserver.Interfaces;

import org.example.applicitacionesserver.Models.ClientsDTO;
import org.example.applicitacionesserver.Models.TenderDTO;

import java.util.List;

public interface ITender {
    TenderDTO CreateTender(TenderDTO information);
    List<TenderDTO> GetALlTenders();
    TenderDTO UpdateTenders(TenderDTO update);
    String DeleteTenderSelected(String currentId);
}
