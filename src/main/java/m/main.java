package m;
import model.CorreoInvalidoException;
import model.EdadInvalidaException;
import model.Encuesta;
import model.NombreInvalidoException;
import services.IDAO;
import services.implDAO;
public class main {
    public static void main(String[] args) {
        IDAO dao = new implDAO();

        try {
            Encuesta encuesta = new Encuesta("David", "kno", "davKno@gmail.com", 20);
            validarEncuesta(encuesta);
            dao.create(encuesta);
            System.out.println("Encuesta guardada exitosamente!");
        }
        catch (NombreInvalidoException | CorreoInvalidoException | EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validarEncuesta(Encuesta encuesta) throws NombreInvalidoException, CorreoInvalidoException, EdadInvalidaException {
        //trim elimina espacios en blanco
        if (encuesta.getPrimerNombre() == null || encuesta.getPrimerNombre().trim().isEmpty() || encuesta.getPrimerNombre().length() > 30) {
            throw new NombreInvalidoException("*** Nombre Invalido ***.");
        }

        if (encuesta.getPrimerApellido() == null || encuesta.getPrimerApellido().trim().isEmpty() || encuesta.getPrimerApellido().length() > 30) {
            throw new NombreInvalidoException("*** Apellido Invalido ***.");
        }

        if (!encuesta.getCorreoElectronico().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            throw new CorreoInvalidoException("*** Correo Invalido ***.");
        }

        if (encuesta.getEdad() < 30 || encuesta.getEdad() > 50) {
            throw new EdadInvalidaException("*** Rango de edad no permitido (30-50) ***.");
        }
    }
}
