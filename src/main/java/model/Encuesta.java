package model;

import jakarta.persistence.*;
import java.util.regex.Pattern;

@Entity
@Table(name = "Encuestas")
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(length = 30, nullable = false)
    private String primerNombre;

    @Column(length = 30, nullable = false)
    private String primerApellido;

    @Column(nullable = false)
    private String correoElectronico;

    @Column(nullable = false)
    private int edad;

    public Encuesta() {
    }


    public Encuesta(String primerNombre, String primerApellido, String correoElectronico, int edad)
            throws NombreInvalidoException, CorreoInvalidoException, EdadInvalidaException {

        setPrimerNombre(primerNombre);
        setPrimerApellido(primerApellido);
        setCorreoElectronico(correoElectronico);
        setEdad(edad);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) throws NombreInvalidoException {
        if (primerNombre == null || primerNombre.trim().isEmpty() || primerNombre.length() > 30) {
            throw new NombreInvalidoException("El primer nombre es inválido.");
        }
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) throws NombreInvalidoException {
        if (primerApellido == null || primerApellido.trim().isEmpty() || primerApellido.length() > 30) {
            throw new NombreInvalidoException("El primer apellido es inválido.");
        }
        this.primerApellido = primerApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) throws CorreoInvalidoException {
        if (!isValidEmail(correoElectronico)) {
            throw new CorreoInvalidoException("El correo electrónico es inválido.");
        }
        this.correoElectronico = correoElectronico;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws EdadInvalidaException {
        if (edad < 30 || edad > 50) {
            throw new EdadInvalidaException("La edad debe estar entre 30 y 50 años.");
        }
        this.edad = edad;
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    @Override
    public String toString() {
        return "Encuesta{" +
                "id=" + id +
                ", primerNombre='" + primerNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", edad=" + edad +
                '}';
    }

}
