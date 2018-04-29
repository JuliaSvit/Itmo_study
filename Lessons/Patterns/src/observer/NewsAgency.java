package observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency{

    private List<Listener> listeners = new ArrayList<>();

    public void subscribe(Listener listener){
        listeners.add(listener);
    }

    public void unsubscribe(Listener listener){
        listeners.remove(listener);
    }

    public void newMessage(String mess){
        System.out.println("Сообщение: " + mess);
    }

    private void notyfyListeners(String mess){

        for (Listener list: listeners){
            list.publish(mess);
        }

    }

    public static void main(String[]args){

        NewsAgency newsAgency = new NewsAgency();

        newsAgency.subscribe(new Listener() {
            @Override
            public void publish(String mess) {
                System.out.println("Listener 1:" + mess);
            }
        });

        newsAgency.subscribe(new Listener() {
            @Override
            public void publish(String mess) {
                System.out.println("Listener 2:" + mess);
            }
        });

    }


}
