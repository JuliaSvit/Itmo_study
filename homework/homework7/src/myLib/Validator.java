package myLib;

//проверка ввода

public class Validator {

    private static final String SYMBOL_REG_EXP = "[]{}^";

    public static boolean isNull(String str){
        return str == null || str.equals("");
    }

    public static boolean itIsLitera(String str) {
        return str.length() == 1 && isNull(str.replaceAll("[A-Z]", ""));
    }

    public static boolean isRegExp(String str){
        return str.contains(SYMBOL_REG_EXP);
    }


    
}
