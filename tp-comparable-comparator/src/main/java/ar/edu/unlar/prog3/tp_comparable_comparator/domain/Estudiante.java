package ar.edu.unlar.prog3.tp_comparable_comparator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante implements Comparable<Estudiante> {
    
    private String legajo;
    private String nombre;
    private double promedio;
    private int edad;
    private int cantidadMateriasAprobadas;

    @Override
    public int compareTo(Estudiante otro) {
        // Orden natural: Merito acadamico (promedio descendente)
        // Se invierte el orden (otro vs this) para que sea descendente en lugar de ascendente.
        return Double.compare(otro.getPromedio(), this.getPromedio());
    }
}