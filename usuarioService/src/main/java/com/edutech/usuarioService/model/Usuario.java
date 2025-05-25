package main.java.com.edutech.usuarioService.model;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String rol; // ADMIN, ESTUDIANTE, SOPORTE, etc.
}
