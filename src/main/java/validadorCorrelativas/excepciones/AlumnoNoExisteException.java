package validadorCorrelativas.excepciones;

public class AlumnoNoExisteException extends RuntimeException {

    public AlumnoNoExisteException(String message) {
        super(message);
    }
}
