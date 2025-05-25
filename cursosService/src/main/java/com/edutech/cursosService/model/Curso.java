package main.java.com.edutech.cursosService.model;

@Entity
public class Curso {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String instructor;
    private int duracion; // horas
}

