package ar.edu.unlar.prog3.tp_comparable_comparator.comparator;

import ar.edu.unlar.prog3.tp_comparable_comparator.domain.Estudiante;
import java.util.Comparator;

public class EstudiantePorNombreComparator implements Comparator<Estudiante> {
    @Override
    public int compare(Estudiante a, Estudiante b) {
        // String ya implementa Comparable correctamente
        return a.getNombre().compareTo(b.getNombre());
    }
}