package testClass;

public class Validator {

    public static boolean validatorLogin(String login){
        if (login == null){
            return false;
        }
        if (login.trim().length() < 3){
            return false;
        }
        return true;
    }
    public static boolean validatorPassword(String password){
        if (password == null){
            return false;
        }
        if (password.trim().length() < 5){
            return false;
        }
        return true;
    }

}
