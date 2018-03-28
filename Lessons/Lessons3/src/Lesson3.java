import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lesson3 {

    public static void main (String[] agrs){

       Lesson3 l3 = new Lesson3();

       l3.arrayList2();

    }

    void arrayList1(){

        // ArrayList динамический массив <тип данных> (размер "по умолчанию 10", после 10 идёт копированние объекта)

        ArrayList<String> list = new ArrayList<>();
        list.add("First Elem"); // добавить в конец массива
        list.add(1,"Second Elem"); //добавить на определённое место index (больше ресурсов)
        System.out.println(list.size()); // размер массива

        String str = list.get(1); //получить элемент по индексу
        int indexArr = list.indexOf("Second Elem"); // пллучает индекс по содержимому
        System.out.println(str + " " + indexArr);

        list.set(1,"New Elem"); //замена

        boolean cont =  list.contains("Second Elem"); //входит ли элемент в массив true/false

        String [] arr = new String[list.size()]; //
        list.toArray(arr); //переводит list в простой массив
        String [] arr2 = list.toArray(new String[list.size()]); // способ №2
        System.out.println(Arrays.toString(arr));

        list.remove(2); // удаление по индексу
        list.remove("Second Elem"); // удаление по значению , если число, то привести к необходимому типу


    }

    void arrayList2(){

        // Связанный список каждый элемент имеет ссылку на рядом стоящие элементы
        List<String> list = new LinkedList<>();
        list.add("Str1");
        list.add("Str2");
        list.add("Str3");
        list.add("Str4");
        System.out.println(list);


    }

}
