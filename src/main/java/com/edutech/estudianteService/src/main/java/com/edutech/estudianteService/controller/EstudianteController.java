package main.java.com.edutech.estudianteService.controller;

import com.edutech.estudiantes.model.Estudiante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private List<Estudiante> estudiantes = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping
    public List<Estudiante> listar() {
        return estudiantes;
    }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        estudiante.setId(idCounter++);
        estudiantes.add(estudiante);
        return estudiante;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtener(@PathVariable Long id) {
        return estudiantes.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = estudiantes.removeIf(e -> e.getId().equals(id));
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
