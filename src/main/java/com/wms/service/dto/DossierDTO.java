package com.wms.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DossierDTO implements Serializable { 
    private Long id;
    private String  denomination;
    private String  identifiantFiscal;
    private String  ice;
    private String  activite;
    private String  adresse;
    private String  codePostal;
    private String  ville;
    private String  email;
    private String  fixe;
    private String  mobile;
    private Date  dateCreationSociete;
    private Long  capital;
    private Long  valeurPart;
    private String  formeJuridique;
    private String  typeComptabilite;
    private Long  droitTimbre;
    private String  regimeTva;
    private String  typeTva;
    private String  imposition;
    private String  registreCommerce;
    private String  numeroTP;
    private String  honoraire;
    private String  periodiciteHonnoraire;
    private String  logo;
    private String  codeAdhesion;
    private String  loginSimpl;
    private String  motPasseSimpl;
    private String  numeroAffiliationCnss;
    private String  codeUtilisationCnss;
    private String  motPasseCnss;
    private List<CompteDTO>  comptes;
    private List<AssocieDTO>  associes;
}
