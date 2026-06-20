package ar.edu.unlar.prog3.tp_comparable_comparator;

import ar.edu.unlar.prog3.tp_comparable_comparator.comparator.EstudiantePorMateriasAprobadasComparator;
import ar.edu.unlar.prog3.tp_comparable_comparator.comparator.EstudiantePorNombreComparator;
import ar.edu.unlar.prog3.tp_comparable_comparator.domain.Estudiante;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainParte3 {
    public static void main(String[] args) {
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("LU-2024-001", "Martín Quiroga",  8.5, 22, 18));
        lista.add(new Estudiante("LU-2024-002", "Valeria Díaz",    8.5, 20, 15)); // Empata promedio
        lista.add(new Estudiante("LU-2024-003", "Facundo Castro",  7.2, 24, 22));

        System.out.println("--- EJERCICIO 4: COMPARATORS CLÁSICOS ---");
        lista.sort(new EstudiantePorMateriasAprobadasComparator());
        System.out.println("Por Materias Aprobadas:");
        lista.forEach(e -> System.out.println(e.getNombre() + " - Materias: " + e.getCantidadMateriasAprobadas()));

        lista.sort(new EstudiantePorNombreComparator());
        System.out.println("\nPor Nombre (Alfabético):");
        lista.forEach(e -> System.out.println(e.getNombre()));

        System.out.println("\n--- EJERCICIO 5: COMPARATORS MODERNOS (Java 8+) ---");
        
        // 1. Lambda explícita
        Comparator<Estudiante> porEdadLambda = (e1, e2) -> Integer.compare(e1.getEdad(), e2.getEdad());
        
        // 2. Comparator.comparing() + method reference
        Comparator<Estudiante> porMateriasModerno = Comparator.comparing(Estudiante::getCantidadMateriasAprobadas);

        // 3. Criterio compuesto con thenComparing() (Promedio descendente, luego nombre)
        Comparator<Estudiante> compuesto = Comparator
                .comparing(Estudiante::getPromedio)
                .reversed() // Promedio descendente
                .thenComparing(Estudiante::getNombre); // Empate -> alfabético ascendente

        lista.sort(compuesto);
        System.out.println("\nCriterio Compuesto (Promedio desc -> Nombre asc):");
        lista.forEach(e -> System.out.println(e.getNombre() + " - Promedio: " + e.getPromedio()));

        // 4. Orden inverso con reversed() (Promedio ascendente)
        Comparator<Estudiante> promedioAscendente = Comparator.comparing(Estudiante::getPromedio);
        lista.sort(promedioAscendente);
        System.out.println("\nCriterio Promedio Ascendente (Reversed a partir del natural):");
        lista.forEach(e -> System.out.println(e.getNombre() + " - Promedio: " + e.getPromedio()));

        lista.sort(porEdadLambda);
        lista.sort(porMateriasModerno);
    }
}
