package com.wms.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "dossier")
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name="numero_t_p")
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
    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn(name="id_dossier")
    private List<Compte> comptes;
    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn(name="id_dossier")
    private List<Associe> associes;
    
}
