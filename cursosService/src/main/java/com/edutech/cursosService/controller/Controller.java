@RestController
@RequestMapping("/api/cursos")
public class Controller {
    @Autowired
    private CursoRepository repo;

    @GetMapping
    public List<Curso> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        return repo.save(curso);
    }
}

