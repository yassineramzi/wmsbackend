package com.wms.service.dto;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.validators.MustMatchRegexExpression;
import com.opencsv.bean.validators.PreAssignmentValidator;

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
public class TvaCsvDTO implements Serializable{

    @CsvBindByName(column = "intitule", required = true)
    private String intitule;

    @CsvBindByName(column = "libelle", required = true)
    private String libelle;

    @CsvBindByName(column = "codeDeclaration", required = true)
    private Long codeDeclaration;

    @PreAssignmentValidator(validator = MustMatchRegexExpression.class, paramString = "^[0-9]{1,2}$")
    @CsvBindByName(column = "taux", required = true)
    private Long taux;

}
