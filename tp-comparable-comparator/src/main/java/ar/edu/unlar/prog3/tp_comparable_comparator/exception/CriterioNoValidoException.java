package ar.edu.unlar.prog3.tp_comparable_comparator.exception;

import lombok.Getter;

@Getter
public class CriterioNoValidoException extends RuntimeException {
    private final String criterioRecibido;

    public CriterioNoValidoException(String criterioRecibido) {
        super("Criterio de ordenamiento no válido");
        this.criterioRecibido = criterioRecibido;
    }
}