package com.wms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class EntityAlreadyExistsException extends Exception{

    @NonNull
    private String errorName;

    @NonNull
    private String message;

}
