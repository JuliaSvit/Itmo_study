import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GoodsList {
    public static final String ADD = "add data";
    public static final String SHOW = "show data";
    public static final String CLOSE = "close";

    private Map<String,Map<String,Integer>> card = new HashMap<>();

    public Map<String, Map<String,Integer>> getCard() {
        return card;
    }

    public void addCard(String str){
        Map<String,Integer> good = new HashMap<>();
        String[]arr = str.split(" ");
        String name = arr[0];
        String tov = arr[1];
        int num = Integer.parseInt(arr[2]);
        System.out.println(num);
        if(this.card.containsKey(name)) {
            good = card.get(name);  // { good: 6 }
            if(good.containsKey(tov)){  //good
                good.put(tov,good.get(tov+num));
            }else {
                good.put(tov,num);
            }
        }else {
            good.put(tov, num);
        }
        this.card.put(name, good);
    }

    public void showCard(){
        for (Map.Entry entry: card.entrySet()){
            System.out.println(entry.getKey() + ":");
            for (Map.Entry en: card.get(entry.getKey()).entrySet()){
                System.out.println(en.getKey() + " " + en.getValue());
            }
        }
    }

    public static void main(String[]args){

        Scanner scaner = new Scanner(System.in);
        GoodsList list = new GoodsList();

        while (true){
            System.out.println("Ведите команду: ");
            String data = scaner.nextLine();
            if(TestClass.goodsListComandTest(data)) {
                if (data.equals(ADD)&&TestClass.goodsListTest(data)) {
                    System.out.println("Введите данные: ");
                    String data1 = scaner.nextLine();
                    list.addCard(data1);
                }
                if (data.equals(SHOW)) {
                    list.showCard();
                }
                if (data.equals(CLOSE)) {
                    System.exit(0);
                }
            }
        }

    }
}