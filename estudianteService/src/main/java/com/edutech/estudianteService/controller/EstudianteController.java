package main.java.com.edutech.estudianteService.controller;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteRepository repo;

    @GetMapping
    public List<Estudiante> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return repo.save(estudiante);
    }
}
