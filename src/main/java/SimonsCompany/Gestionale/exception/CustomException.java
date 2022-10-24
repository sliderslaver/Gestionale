package SimonsCompany.Gestionale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends RuntimeException {
        public BadRequestException() {
        }

        public BadRequestException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class NotFoundException extends RuntimeException {
        public NotFoundException() {
        }

        public NotFoundException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public static class UnauthorizedException extends RuntimeException {
        public UnauthorizedException() {
        }

        public UnauthorizedException(String message) {
            super(message);
        }
    }
}