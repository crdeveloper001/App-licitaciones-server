package org.example.applicitacionesserver.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor

@Document("Tenders")
public class TenderDTO {
    @Id
    private String _id;
    private String tender_name;
    private String tender_description;
    private String tender_client;
    private String tender_client_email;
    private Date tender_begin;
    private Date tender_end;
    private Integer tender_budget;
    private String tender_state;
}
