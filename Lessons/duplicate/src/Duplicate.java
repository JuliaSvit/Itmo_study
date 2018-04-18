import java.util.*;

public class Duplicate {


    private Map<String ,Integer> map = new HashMap<>();

    public Map<String,Integer> getMap (){
        return this.map;
    }

    private void addMap(String str){
        if(map.containsKey(str)) {
            map.put(str, map.get(str)+1);
        } else {
            map.put(str,1);
        }
    }

    public void addToMap(String num){

        String[] numArr = num.split(" ");
        for (String str: numArr){
            str = str.replaceAll(" ", "");
            if(!str.isEmpty()) {
                addMap(str);
            }
        }
    }

    public void printAll(){
        System.out.println("Все значения: ");
        for (Map.Entry<String,Integer> entry: this.map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void printRepit(){
        System.out.println("Повторяющееся значения: ");
        for (Map.Entry<String,Integer> entry: this.map.entrySet()) {
            if(entry.getValue()>1) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public static void palindrom(String num){

        String[] str = num.split(" ");

        System.out.println("Ищем палиндромы: ");

        for(int i = 0; i < str.length; i++){

            if(str[i].equals(new StringBuffer(str[i]).reverse().toString())){

                System.out.println(str[i]);

            }

        }

    }

    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        Duplicate duplicate = new Duplicate();
        while (true) {
            System.out.println("Введите числа через пробел: ");
            String num = scanner.nextLine();
            if(num.isEmpty()){
                System.exit(0);
            }
            if(TestClass.duplicateTest(num)) {
                duplicate.addToMap(num);
                duplicate.printRepit();
                duplicate.printAll();
            } else {
                palindrom(num);
            }

        }

    }
}
