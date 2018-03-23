import java.util.Arrays;
/*
* //////////////////javap -c file_name  - в консоли выводит инфу по компиляции
* file_name имя скомпилированного файла в out *.class
*
* */
public class Lessons2 {

    public static void main (String[]args){

        //////////////////////////  Массивы

        int arr1[] = new int[4];
        String[] arr2 = new String[3];
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int a = 4;
        int [] arr3 = {a,8,9,1,-23,67};

         /////// Обращение к элементам массыва
        int arr3Elem = arr3[2];

        for (int i = 0; i < arr2.length; i++){

            arr2[i] = "elem # " + i;

        }

        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < arr3.length; i++){
            System.out.println(i + " - " + arr3[i]);
        }


        ///////////// Вывод по колекции
        for (int arr_val : arr3){
//            arr_val = 5;
            System.out.println("val " + arr_val);
        }
        System.out.println(Arrays.toString(arr3));

        ////////////////////// Копирование массива

        int [] newArr3 = arr3.clone();

        /*System.arraycopy(
                массив - источник,
                пизиция - начало нового массива,
                массив назначения,
                начальная позиция целевого массива,
                кол-во копитуемых элементов
                );*/
        int [] newArr4 = new int[3];
        System.arraycopy(arr3,2, newArr4, 0, 2);

        System.out.println(Arrays.toString(newArr4));

       // Arrays.copyOf(Исходный массив, длина нового массива);
        int [] newArr5 = Arrays.copyOf(arr3,2);
       //Arrays.copyOfRange(Исходный массив, начальний индекс, конечный индекс);
        int [] newArr6 = Arrays.copyOfRange(arr3, 2, 4);
        System.out.println(Arrays.toString(newArr5));
        System.out.println(Arrays.toString(newArr6));

        /////// Сравнение массивов

        Arrays.equals(arr1,arr3);

//        Arrays.fill(arr1, 2); // заполнение массива одинаковыми значениями

        /// поиск по массиву  выводит индекс (-1 не нашел)
        // для бинарного поиска нужен отсортированный массив
        //Arrays.binarySearch(массив, индекс)
        //Arrays.binarySearch(массив, начальная позиция поиска, конечная позиция, ключ)


        // Сортировка массива

        //Arrays.sort(arr3);

        Arrays.parallelSort(arr3); //паралелльная сортировка быстее


        int c =  Arrays.binarySearch(arr3, 9);
        System.out.println(c);

        ///////////////////////////////////////////////////////////////////////

        /////Многомерные массивы

        int [][] arr2D;
        int [][][] arr3D;

        int [][] arr2d = new int[10][];

        for (int i = 0; i < arr2d.length; i++){
            arr2d[i] = new int [i];
           // System.out.println(Arrays.deepToString(arr2d));
        }

        for (int i = 0; i < arr2d.length; i++){
            System.out.println(Arrays.toString(arr2d[i]));
        }

    }

}
