package myLib;

//Чтение со строки

import java.util.Scanner;


public class Reader {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static String readString() throws MyException{
        String text = scanner.nextLine();
        if (Validator.isNull(text))
            throw new MyException("Пустая строка.");
        return text;
    }

    public static char readChar() throws MyException{
        String text = scanner.nextLine().toUpperCase();
        if (Validator.isNull(text))
            throw new MyException("Пустая строка.");
        if (!Validator.itIsLitera(text)){
            throw new MyException("Это не буква или больше одной буквы");
        }
        return text.charAt(0);
    }
    
}

