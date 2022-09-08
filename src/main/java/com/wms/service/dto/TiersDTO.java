package com.wms.service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TiersDTO implements Serializable { 
    private Long id;
    private String identifiantFiscal;
    private String designation;
    private String activite;
    private String adresse;
    private String rib;
    private String email;
    private String ice;
    private String registreCommerce;
    private String telephone;
    private String ville;
    private String banque;
    private String echeance;
    private String typeEcheance;
    private String devise;
}
