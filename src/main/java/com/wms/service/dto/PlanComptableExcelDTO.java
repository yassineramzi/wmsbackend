package com.wms.service.dto;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanComptableExcelDTO implements Serializable {
    private Long id;
    private String numeroCompte;
    private String intituleCompte;
    private String debit;
    private String typeCompte;
    private String general;
}
