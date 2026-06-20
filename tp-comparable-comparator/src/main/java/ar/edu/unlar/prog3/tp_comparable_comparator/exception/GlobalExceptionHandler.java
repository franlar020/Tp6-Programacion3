package ar.edu.unlar.prog3.tp_comparable_comparator.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CriterioNoValidoException.class)
    public ResponseEntity<Map<String, Object>> handleCriterioNoValido(CriterioNoValidoException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", ex.getMessage());
        body.put("criterioRecibido", ex.getCriterioRecibido());
        body.put("criteriosAceptados", List.of("promedio", "edad", "nombre", "materiasAprobadas", "legajo"));

        return ResponseEntity.badRequest().body(body);
    }
}