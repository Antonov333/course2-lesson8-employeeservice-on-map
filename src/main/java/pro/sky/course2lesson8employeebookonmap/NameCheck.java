package pro.sky.course2lesson8employeebookonmap;

public class NameCheck {

    private final String firstName;
    private final String lastName;
    private int code;
    private String message;
    private boolean ok;

    public NameCheck(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

            /*
        0 - OK
        1 - both null
        2 - first OK, last null
        3 - first null, last OK
         */
        if (firstName != null && lastName != null) {
            code = 0;
            message = "OK";
        }
        if (firstName == null && lastName == null) {
            code = 1;
            message = "first and last names are missing";
        }
        if (firstName != null && lastName == null) {
            code = 2;
            message = "last name is missing";
        }
        if (firstName == null && lastName != null) {
            code = 3;
            message = "first name is missing";
        }
        ok = (code == 0);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isOk() {
        return ok;
    }
}
