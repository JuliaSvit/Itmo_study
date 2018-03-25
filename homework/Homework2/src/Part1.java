import java.util.Random;
import java.util.Scanner;

public class Part1 {

    /*1) Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран сначала в строку,
    отделяя один элемент от другого пробелом, а затем в столбик (отделяя один элемент от другого началом новой строки).
    Перед созданием массива подумайте, какого он будет размера. 2 4 6 … 18 20 */

    void even_numbers (){
        System.out.println("\n1. Массив чётных чисел:");
        int [] even = new int[10];
        for (int i = 0; i < 10; i++){
            even[i] = (i+1)*2;
            System.out.print(even[i] + " ");
        }
        System.out.println("");
        for (int num: even){
            System.out.println(num);
        }
    }

    /*2) Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
    а затем этот же массив выведите на экран тоже в строку,
    но в обратном порядке (99 97 95 93 … 7 5 3 1).*/

    void odd_numbers(){

        System.out.println("\n2. Массив чётных нечисел:");
        int [] oddNum = new int[50];
        for (int i = 0; i < 50; i++){
            oddNum[i] = i * 2 + 1;
            System.out.print(oddNum[i] + " ");
        }
        System.out.println("");
        for (int i = 49; i >= 0; i--) {
            System.out.print(oddNum[i] + " ");
        }
        System.out.println("");
    }

    /*3) Создайте массив из 15 случайных целых чисел из отрезка [0;9].
    Выведите массив на экран. Подсчитайте сколько в массиве чётных элементов
    и выведете это количество на экран на отдельной строке.*/

    void randomArr(){

        System.out.println("\n3. Массив из 15-ти случайных чисел отрезка [0;9]:");
        int [] arr = new int[15];
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*10);
            System.out.print(arr[i] + " ");
            if (arr[i]%2 == 0){
                count++;
            }
        }
        System.out.println("\nВ массиве " + count + " чётных элементов");

    }

    /*4) Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый,
    выведите массивы на экран в двух отдельных строках.
    Посчитайте среднее арифметическое элементов каждого массива и сообщите,
    для какого из массивов это значение оказалось больше (либо сообщите,
    что их средние арифметические равны)*/

    void averageArr(){

        System.out.println("\n4. Два массива случайных чисел:");
        int [] arr1 = new int[5];
        int [] arr2 = new int[5];

        Random random = new Random();
        for (int i = 0; i < 5; i++){
            arr1[i] = (int)(Math.random()*6);
            arr2[i] = random.nextInt(6);
        }

        System.out.println("Первый массив:");
        double average1 = 0;
        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i] + " ");
            average1 += arr1[i];
        }
        System.out.println("\nВторой массив:");
        double average2 = 0;
        for(int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
            average2 += arr2[i];
        }

        average1/=arr1.length;
        average2/=arr2.length;

        if(average1 == average2){
            System.out.println("\nСреднее арифметическое значение в каждом из двух массивов равны");
        } else if (average1 > average2){
            System.out.println("\nДля первого массива среднее арифметическое значение больше");
        } else {
            System.out.println("\nДля второго массива среднее арифметическое значение больше");
        }

    }

    /*5) Создайте массив из 4 случайных целых чисел из отрезка [10;99],
    выведите его на экран в строку. Определить и вывести на экран сообщение о том,
    является ли массив строго возрастающей последовательностью.
     */

    void sequence (){

        System.out.println("\n5. Является ли массив строго возрастающей последовательностью:");
        int [] arr = new int[4];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i] = 10 +  random.nextInt(100 - 10);
            System.out.print(arr[i] + " ");
        }
        if (arr[0]<arr[1] && arr[1]<arr[2] && arr[2]<arr[3]){
            System.out.println("\nДанный массив со строго возрастающей последовательностью.");
        } else {
            System.out.println("\nУ данного массива нет строго возрастающей последовательности.");
        }

    }

    /*6) Пользователь должен указать с клавиатуры чётное положительное число,
    а программа должна создать массив указанного размера из случайных целых чисел из [-5;5] и вывести его на экран в строку.
    После этого программа должна определить и сообщить пользователю о том,
    сумма модулей какой половины массива больше: левой или правой, либо сообщить, что эти суммы модулей равны.
    Если пользователь введёт неподходящее число, то программа должна требовать повторного ввода до тех пор,
    пока не будет указано корректное значение.*/

    void ScannerArr(){

        System.out.println("\n6. Ввод с кравиатуры.");

        Scanner sc = new Scanner(System.in);
        int lengthArr;
        do {
            System.out.println("Введите чётное положительное число:");
            lengthArr = sc.nextInt();
            if (lengthArr > 0 && lengthArr%2 == 0){
                break;
            }
            System.out.println("!!!Вы ввели не положительное или нечётное число!!!");
        } while (true);

        int [] arr = new int[lengthArr];
        Random random = new Random();
        int left = 0, right = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = -5 + random.nextInt(6 + 5);
            System.out.print(arr[i] + " ");
            if (i < arr.length/2){
                left += Math.abs(arr[i]);
            } else {
                right += Math.abs(arr[i]);
            }
        }

        String answer;
        if(right == left){
            answer = "Сумма модулей половины массива равны";
        } else if (right < left){
            answer = "Сумма модулей левой половины больше";
        } else {
            answer = "Сумма модулей правой половины больше";
        }
        System.out.println("\n" + answer);
    }

    /*7) Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел из отрезка [-99;99].
    Вывести массив на экран.
    После на отдельной строке вывести на экран значение максимального элемента этого массива (его индекс не имеет значения).*/

    void arrey2D(){

        System.out.println("\n7. Двуменрый массив.");
        int arr [][] = new int[5][8];

        Random random = new Random();
        int max = -99;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = -99 + random.nextInt(100 + 99);
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] > max){
                    max = arr[i][j];
                }
            }
            System.out.println("");
        }

        System.out.println("Мексимальное значение массива: " + max);
    }

    /*8) Для проверки остаточных знаний учеников после летних каникул,
    учитель младших классов решил начинать каждый урок с того,
    чтобы задавать каждому ученику пример из таблицы умножения,
    но в классе 15 человек, а примеры среди них не должны повторяться.
    В помощь учителю напишите программу, которая будет выводить на экран 15 случайных примеров из таблицы умножения
    (от 2*2 до 9*9, потому что задания по умножению на 1 и на 10 — слишком просты).
    При этом среди 15 примеров не должно быть повторяющихся
    (примеры 2*3 и 3*2 и им подобные пары считать повторяющимися).*/

    void multiplication(){

        System.out.println("\n8. Таблица умножения.");
        // создаём и заполняем массив из 15 множемых элементов
        int arr1 [] = new int[15];
        Random random = new Random();
        for (int i = 0; i < arr1.length; i++){
            arr1[i]= 2 + random.nextInt(10 - 2);
        }
        //создаём и заполняем массив из 15 множителей
        int [] arr2 = new int[15];
        for (int i = 0; i < arr2.length; i++){
            do{
                int x = 2 + random.nextInt(10 - 2); // создаётся рандомное число
                if (i == 0){ // если это первый элемент, то сразу его записываем
                    arr2[i] = x;
                    break; //выход из while
                } else {
                    // Проверяем, повторяется ли комбинация для элементов, которые уже были записаны
                    boolean trigger = true;
                    for (int j = 0; j < i; j++){ // перебераем предыдущие комбинации
                        if ((arr2[j] == x && arr1[i] == arr1[j])|| (arr2[j] == arr1[i] && arr1[j] == x)){ // если нашли повторение:
                            trigger = false;
                            break; // выход из for
                        }
                    }
                    // если повторений не найдено (trigger = true), то добавляем новый элемент,
                    // иначе возвращаемся на создание нового элемента
                    if (trigger) {
                        arr2[i] = x;
                        break; //выход из while
                    }
                }
            }while (true);
        }
        for (int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i] + " X " + arr2[i] + " =");
        }

    }

}
