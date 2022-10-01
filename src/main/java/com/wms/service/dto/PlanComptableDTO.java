package com.wms.service.dto;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanComptableDTO implements Serializable {
    private Long id;
    private Long numeroCompte;
    private String intituleCompte;
    private String debit;
    private String typeCompte;
    private String general;
}
