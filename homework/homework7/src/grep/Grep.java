package grep;

import myLib.*;
import myLib.Reader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Необходимо реализовать консольную программу, которая бы фильтровала поток
 * текстовой информации подаваемой на вход и на выходе показывала лишь те строчки, 
 * которые содержат слово передаваемое программе на вход в качестве аргумента.

* Программа не должна учитывать регистр
* В аргументах может быть передано не одно слово, а несколько
* В качестве аргумента может быть задано не конкретное слово, а регулярное выражение
 */
public class Grep {
    
    private String arg;
    private ArrayList<String> textList = new ArrayList<String>();

    public void enterArg(){
        while (true) {            
            System.out.println("Введате аргумент:");
            try {
                arg = Reader.readString().toLowerCase();
            } catch (MyException e) {
                System.out.println(e.getMessage() + " \nВведите аргумент ещё раз или exit для выхода из программы");
                continue;
            }
            if(arg.equals("exit")){
                System.exit(0);
            }
            break;
        }
    }

    public void enterText(){
        System.out.println("Введите текст. \nДля завершения программы введите exit");
        while (true) {   
            String text;
            try {
                text = Reader.readString().toLowerCase();
            } catch (MyException e) {
                System.out.println(e + " \nИли введите текст ещё раз, или exit для завершения программы");
                continue;
            }
            if (text.equals("end")) break;
            exit(text);
            textList.add(text);
            System.out.println("Введите ещё одну строку.\nЧто бы закончить ввод введите end \nДля завершения прогрпммы введите exit");
            exit(text);
        }
        
    }

    public void readText(){
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("src/grep/text.txt"), Charset.forName("UTF-8")
                )
        ))
        {
            String str;
            while((str = reader.readLine()) != null){
                textList.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void exit(String str){
        if(str.equals("exit")){
            System.exit(0);
        }
    }

    public void filterText(){
        for(String str: textList){
            if(checkWithWord(str, arg)||checkWithRegExp(str, arg + "+")){
                System.out.println(str);
            }
        }
    }
    
    private static boolean checkWithRegExp(String txt, String regexp){
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(txt);
        return m.matches();
    }

    private static boolean checkWithWord(String txt, String word){
        return txt.contains(word);
    }
    
}
