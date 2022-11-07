package com.wms.dto;

import com.wms.domain.PlanComptable;
import lombok.Data;

import java.io.Serializable;

@Data
public class JournalDTO implements Serializable {
    private Long id;
    private String typeJournal;
    private String nomJournal;
    private PlanComptable planComptable;
}
