package Exception;

public class LecturerNotFoundException extends RuntimeException {
    public LecturerNotFoundException() {
        super("Lecturer not found");
    }

    public LecturerNotFoundException(String message) {
        super(message);
    }

    public LecturerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LecturerNotFoundException(Throwable cause) {
        super(cause);
    }
}
