package main.java.com.edutech.usuarioService.controller;
import com.edutech.usuarios.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping
    public List<Usuario> listar() {
        return usuarios;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        usuario.setId(idCounter++);
        usuarios.add(usuario);
        return usuario;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Long id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = usuarios.removeIf(u -> u.getId().equals(id));
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
