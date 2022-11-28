package com.wms.service.dto;

import java.io.Serializable;

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
public class AssocieDTO implements Serializable {
    private Long id;
    private String nom;
    private String email;
    private String telephone;
    private String cin;
    private String adresse;
    private Long nombrePart;
    private boolean gerant;
}
