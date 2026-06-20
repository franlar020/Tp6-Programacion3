package ar.edu.unlar.prog3.tp_comparable_comparator.controller;

import ar.edu.unlar.prog3.tp_comparable_comparator.domain.Estudiante;
import ar.edu.unlar.prog3.tp_comparable_comparator.service.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estudiante> getEstudiantes(
            @RequestParam(defaultValue = "promedio") String sortBy,
            @RequestParam(defaultValue = "asc") String order) {

        return service.ordenar(sortBy, order);
    }
}