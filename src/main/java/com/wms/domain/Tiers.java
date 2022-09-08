package com.wms.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tiers")
public class Tiers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
