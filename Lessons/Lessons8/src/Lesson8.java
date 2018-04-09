import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Lesson8 {

    public static void main(String []args) throws IOException {
        /*Set<String>strings = new HashSet<>();
        System.out.println(strings.add("12"));
        System.out.println(strings.add("34"));
        System.out.println(strings.add("12"));//элемент не добавился и вернул false
        System.out.println(strings.add("45"));

        System.out.println(strings.size() + "\n///////////////////////////");

        for (String str: strings){
            System.out.println(str);
        }

        Iterator<String> iterator = strings.iterator();  // перебор коллекции
        while (iterator.hasNext()){
            System.out.println("С итератором " + iterator.next());
        }
*/
        ArrayList<String>arrLst = new ArrayList<>();
        LinkedList<String>linkedList = new LinkedList<>();

        // subList позволяет работать с частью списка [x,y)
//        arrLst.subList(1,3).clear();  //удаление
//        arrLst.get(1);

        Queue<String> queue = linkedList;
        Queue<String> queue1 = new PriorityQueue<>();
        Queue<String> queue2 = new ArrayDeque<>();

        //    Для каждой строки
//    1. перевести в нижний регистр
//    2, убрать пробелы в начале и в конце строки
//    3, переместить в коллекцию только не пустые слова


        File txt = new File("src/test.txt");
        List lines = Files.readAllLines(txt.toPath()); //List <String> lines
        ArrayList<String> arrayList = new ArrayList<>();


        Iterator<String> iterator = lines.iterator();  // перебор коллекции
        while (iterator.hasNext()){
            String st = iterator.next().trim().toLowerCase();
            String[]sr = st.split(" ");
            for (String s: sr)
                arrayList.add(s);
        }
        for (String str: arrayList){
            System.out.println(str);
        }




    }



}
