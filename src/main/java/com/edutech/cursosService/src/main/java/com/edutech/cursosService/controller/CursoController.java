package com.edutech.cursosService.controller;

import com.edutech.cursosService.model.Curso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    private List<Curso> cursos = new ArrayList<>();
    private Long contadorId = 1L;

    @GetMapping
    public List<Curso> listar() {
        return cursos;
    }

    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        curso.setId(contadorId++);
        cursos.add(curso);
        return curso;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtener(@PathVariable Long id) {
        return cursos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = cursos.removeIf(c -> c.getId().equals(id));
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

