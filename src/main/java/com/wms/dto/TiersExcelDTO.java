package com.wms.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TiersExcelDTO implements Serializable{

    @NotEmpty
    @Pattern(regexp = "^[0-9]{10}$")
    private String identifiantFiscal;
    
    @NotEmpty
    private String designation;

    @NotEmpty
    private String activite;

    @NotEmpty
    private String adresse;

    @NotEmpty
    @Pattern(regexp = "^[0-9]{24}$")
    private String rib;

    @Email
    private String email;

    @NotEmpty
    @Pattern(regexp = "^[0-9]{15}$")
    private String ice;

    @NotEmpty
    private String registreCommerce;

    @NotEmpty
    @Pattern(regexp = "^[0-9]{10}$")
    private String telephone;

    private String ville;

    @NotEmpty
    private String banque;

    @NotEmpty
    private String echeance;

    @NotEmpty
    private String typeEcheance;

    @NotEmpty
    private String devise;

    public static boolean isValid(
        @Validated final TiersExcelDTO tiersExcelDTO,
        final BindingResult result
    ) {
        return !result.hasErrors();
    }
    
}
