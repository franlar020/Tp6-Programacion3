package ar.edu.unlar.prog3.tp_comparable_comparator.service;

import ar.edu.unlar.prog3.tp_comparable_comparator.domain.Estudiante;
import ar.edu.unlar.prog3.tp_comparable_comparator.exception.CriterioNoValidoException;
import ar.edu.unlar.prog3.tp_comparable_comparator.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;
    private final Map<String, Comparator<Estudiante>> estrategias;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;

        // Mapeo O(1) de las estrategias de comparación mediante Method References
        this.estrategias = Map.of(
            "promedio", Comparator.comparing(Estudiante::getPromedio),
            "edad", Comparator.comparing(Estudiante::getEdad),
            "nombre", Comparator.comparing(Estudiante::getNombre),
            "materiasAprobadas", Comparator.comparing(Estudiante::getCantidadMateriasAprobadas),
            "legajo", Comparator.comparing(Estudiante::getLegajo)
        );
    }

    public List<Estudiante> ordenar(String sortBy, String order) {
        Comparator<Estudiante> comparador = estrategias.get(sortBy);

        if (comparador == null) {
            throw new CriterioNoValidoException(sortBy);
        }

        // Tie-breaker por defecto para resolver empates de manera determinista
        comparador = comparador.thenComparing(Estudiante::getLegajo);

        if ("desc".equalsIgnoreCase(order)) {
            comparador = comparador.reversed();
        }

        List<Estudiante> lista = repository.findAll();
        lista.sort(comparador);

        return lista;
    }
}