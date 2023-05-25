package pro.sky.course2lesson8employeebookonmap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException() {
        super("EmployeeNotFoundException");
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
