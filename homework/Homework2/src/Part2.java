import java.util.Scanner;

public class Part2 {

    /*1) Найти в строке указанную подстроку и заменить ее на новую.
    Строку, ее подстроку для замены и новую подстроку вводит пользователь.*/

    void stringRewrite(){

        System.out.println("\n1. Найти в строке указанную подстроку и заменить ее на новую.");
        Scanner sc = new Scanner(System.in);
        String str1;
        String str2;
        String str3;
        System.out.println("Введите строку:");
        str1 = sc.nextLine();
        do {
            System.out.println("Введите строку которую нужно заменить:");
            str2 = sc.nextLine();
                 if (str1.contains(str2)){
                     System.out.println("Введите новую строку:");
                     str3 = sc.nextLine();
                     str1 = str1.replaceAll(str2,str3);
                     break;
                 }else {
                     System.out.println("Упс! Заменять нечего :(\nВвести новую строку для замены? (y/n):");
                     String answer = sc.nextLine();
                     System.out.println(answer);
                     if (answer.equals("n")){
                         System.out.println("Пока, пока!!!");
                         break;
                     }
                 }
        }while (true);
        System.out.println(str1);

    }

    /*2) Требуется удалить из нее повторяющиеся символы и все пробелы.
    Например, если было введено "abc cde def", то должно быть выведено "abcdef"*/

    void repeatChar(){

        System.out.println("\n2. Удалить повторяющиеся символы и все пробелы.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = sc.nextLine();
        str = str.replaceAll(" ","");
        StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i < sb.length()-1; i++){
            char ch = sb.charAt(i);
            for (int j = i+1; j < sb.length();){
                if (ch == sb.charAt(j)){
                    sb.deleteCharAt(j);
                }else {
                    j++;
                }
            }
        }
        System.out.println(sb.toString());

    }

    /*3) Вводится строка, содержащая буквы, целые неотрицательные числа и иные символы.
    Требуется все числа, которые встречаются в строке, поместить в отдельный целочисленный массив.
    Например, если дана строка "дом 48, корпус 9, парадная 7, этаж 4", то в массиве должны оказаться числа 48, 9, 7 и 4*/

    void regExp(){

        System.out.println("\n3. Записать из строки все числа в массив.");
        System.out.println("Введите строку содержащая буквы, целые неотрицательные числа и иные символы:");

        Scanner sc = new Scanner(System.in);

        String [] st = sc.nextLine().split(" ");
        int [] temp = new int[st.length];
        int k = 0;

        for (int i = 0; i < st.length; i++){
            st[i] = st[i].replaceAll("\\D","");
            if (!st[i].isEmpty()){
                temp[k] = Integer.parseInt(st[i]);
                k++;
            }
        }
        int [] strNum = new int[k];
        for (int i = 0; i < k; i++){
            strNum[i] = temp[i];
            System.out.print(strNum[i] + " ");
        }

    }

}
