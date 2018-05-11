package alarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sensor {

    private List<Alarm> listeners = new ArrayList<>();

    public void subscribe(Alarm listener) {
        listeners.add(listener);
    }

    public void unsubscribe(Alarm listener) {
        listeners.remove(listener);
    }

    private void message(){
        System.out.println("Запуск системы!");
    }

    private void notyfyListeners(int temp) {
        for (Alarm list : listeners) {
            list.tempChanged(temp);
        }
    }

    public void genTemp() throws InterruptedException {
        message();
        int temp = 80;
        Random random = new Random();
        while (temp < 700){
            int num = random.nextInt(10);
            temp = num > 5 ? (temp + num) : (temp - num);
            notyfyListeners(temp);
            Thread.sleep(100);
        }
        System.out.println("БУУУУМ!!!!");
    }
}