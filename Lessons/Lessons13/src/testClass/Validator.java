package testClass;

import projectEnum.CommandsEnum;

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
        if (password.trim().length() < 3){
            return false;
        }
        return true;
    }

    public static boolean validatorCommands(String command){
        boolean hasComm = true;
        try {
            CommandsEnum.valueOf(command);
        }catch (IllegalArgumentException e){
            hasComm = false;
        }
        return hasComm;
    }

}
