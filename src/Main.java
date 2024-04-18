import Errors.WrongLoginException;
import Errors.WrongPasswordException;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            getLoginAndPassword("LoGiN1234567890", "PaSwOrD12345678900", "PaSwOrD12345678900");
        } catch (WrongLoginException | WrongPasswordException error) {
            System.out.println(error.getMessage());
        }
    }

    public static void getLoginAndPassword(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        boolean loginNew = login.matches("^+\\w+$");
        boolean passwordNew = password.matches("^+\\w+$");

        if (!loginNew || login.length() > 20) {
            throw new WrongLoginException("Логин содержит недопустимые символы или превышает 20 символов");
        }
        if (!passwordNew || password.length() > 20) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы или превышает 20 символов");
        } else if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
