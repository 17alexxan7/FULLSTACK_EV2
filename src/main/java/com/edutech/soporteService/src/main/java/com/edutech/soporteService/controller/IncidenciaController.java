package main.java.com.edutech.soporteService.controller;

import com.edutech.soporte.model.Incidencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {

    private List<Incidencia> incidencias = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping
    public List<Incidencia> listar() {
        return incidencias;
    }

    @PostMapping
    public Incidencia crear(@RequestBody Incidencia incidencia) {
        incidencia.setId(idCounter++);
        incidencias.add(incidencia);
        return incidencia;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> obtener(@PathVariable Long id) {
        return incidencias.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = incidencias.removeIf(i -> i.getId().equals(id));
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
