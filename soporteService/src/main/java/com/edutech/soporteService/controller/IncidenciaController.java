package main.java.com.edutech.soporteService.controller;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {
    @Autowired
    private IncidenciaRepository repo;

    @GetMapping
    public List<Incidencia> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Incidencia crear(@RequestBody Incidencia incidencia) {
        return repo.save(incidencia);
    }
}
