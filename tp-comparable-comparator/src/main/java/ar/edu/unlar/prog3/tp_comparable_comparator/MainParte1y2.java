package ar.edu.unlar.prog3.tp_comparable_comparator;

import ar.edu.unlar.prog3.tp_comparable_comparator.domain.Estudiante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainParte1y2 {
    public static void main(String[] args) {
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("LU-2024-001", "Martín Quiroga", 8.5, 22, 18));
        lista.add(new Estudiante("LU-2024-002", "Valeria Díaz",   8.5, 20, 15));
        lista.add(new Estudiante("LU-2024-003", "Facundo Castro", 7.2, 24, 22));
        lista.add(new Estudiante("LU-2024-004", "Camila Torres",  9.1, 21, 24));

        // EJERCICIO 1: el error que dispara todo
        // Si la clase Estudiante NO implementa Comparable, la siguiente línea genera:
        // "The method sort(List<T>) in the type Collections is not applicable for the arguments (List<Estudiante>)"
        // Collections.sort(lista);

        // EJERCICIO 2: IMPLEMENTAR Comparable<Estudiante>
        System.out.println("--- LISTA ORIGINAL ---");
        lista.forEach(e -> System.out.println(e.getNombre() + " - Promedio: " + e.getPromedio()));

        Collections.sort(lista);

        System.out.println("\n--- LISTA ORDENADA (Orden Natural: Promedio Descendente) ---");
        lista.forEach(e -> System.out.println(e.getNombre() + " - Promedio: " + e.getPromedio()));
    }
}