package ar.edu.unlar.prog3.tp_comparable_comparator;

import ar.edu.unlar.prog3.tp_comparable_comparator.domain.Estudiante;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EstudianteComparatorTest {

    @Test
    void testAntiPatronRestaProvocaOverflow() {
        Estudiante e1 = new Estudiante("1", "A", 9.0, Integer.MAX_VALUE, 10);
        Estudiante e2 = new Estudiante("2", "B", 9.0, -1, 10);

        // INCORRECTO
        Comparator<Estudiante> restaTramposa = (a, b) -> a.getEdad() - b.getEdad();

        int resultado = restaTramposa.compare(e1, e2);

        // Integer.MAX_VALUE - (-1) genera un overflow a -2147483648
        // El test verifica que el comparador devuelve un valor NEGATIVO, 
        // indicando erróneamente que e1 (el máximo) es MENOR que e2 (-1).
        assertTrue(resultado < 0, "El desbordamiento provocó un falso negativo");
    }

    @Test
    void testIntegerCompareManejaEdadesExtremasCorrectamente() {
        Estudiante e1 = new Estudiante("1", "A", 9.0, Integer.MAX_VALUE, 10);
        Estudiante e2 = new Estudiante("2", "B", 9.0, -1, 10);

        // CORRECTO
        Comparator<Estudiante> comparadorSeguro = (a, b) -> Integer.compare(a.getEdad(), b.getEdad());

        int resultado = comparadorSeguro.compare(e1, e2);

        // Integer.compare resuelve correctamente que MAX_VALUE es MAYOR que -1 (resultado > 0)
        assertTrue(resultado > 0, "Integer.compare falló en la comparación");
        assertEquals(1, resultado); // Devuelve estrictamente 1
    }
}