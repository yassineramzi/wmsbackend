package com.wms.service.dto;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviseDTO implements Serializable {
    private Long id;
    private String designation;
    private Long taux;
}
