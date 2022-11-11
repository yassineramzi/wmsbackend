package com.wms.dto;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TvaExcelDTO implements Serializable {
    private Long id;
    private String intitule;
    private String libelle;
    private Long codeDeclaration;
    private Long taux;
}
