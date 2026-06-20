package ar.edu.unlar.prog3.tp_comparable_comparator.comparator;

import ar.edu.unlar.prog3.tp_comparable_comparator.domain.Estudiante;
import java.util.Comparator;

public class EstudiantePorMateriasAprobadasComparator implements Comparator<Estudiante> {
    @Override
    public int compare(Estudiante a, Estudiante b) {
        return Integer.compare(a.getCantidadMateriasAprobadas(), b.getCantidadMateriasAprobadas());
    }
}