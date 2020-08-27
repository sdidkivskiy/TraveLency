package org.TraveLency.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class MainException extends RuntimeException{
    private String message;
    private Long exceptionCode;
}
