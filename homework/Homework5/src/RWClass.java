import java.util.Arrays;
import java.util.Scanner;
import rwConfig.*;

public class RWClass {

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        RWHandler rwHandler;

        do {
            System.out.println("Введите Имя файла: ");
            String str = sc.nextLine();
            rwHandler = RWHandler.getInstanse(str);
            if(rwHandler != null){
                break;
            }
            System.out.println("Вы ввели не правильное имя файла или данное расширение не поддерживется.\n" +
                    "Хотите продолжить или выйти? Для выхода ввведите exit.");
            if (sc.nextLine().equals("exit")){
                System.exit(0);
            }
        }while (true);

    }

}
