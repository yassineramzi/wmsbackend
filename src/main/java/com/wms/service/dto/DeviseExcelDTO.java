package com.wms.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviseExcelDTO implements Serializable {
    @NotEmpty
    private String designation;
    @NotEmpty
    private Long taux;
}
