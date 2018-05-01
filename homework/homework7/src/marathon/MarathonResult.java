package marathon;

import myLib.MyException;

import java.time.LocalTime;
import java.util.*;

/*4) Группа людей участвует в марафоне, их имена хранятся в одно массиве,
а время за которое они пробежали марафон в другом.
Задача найти человека, который быстрее всех пробежал дистанцию и вывести его имя и счет.
Найдите человека, который прибежал вторым.*/

public class MarathonResult {

    private final String[]participants;
    private final ArrayList<LocalTime>result;
    private ArrayList<LocalTime>sortResult;

    public MarathonResult(String[]participants, LocalTime[] result) throws MyException{
        if (participants.length != result.length){
            throw new MyException("Не совпадает часло участников и результатов");
        }
        this.participants = participants;
        this.result = new ArrayList<>(Arrays.asList(result));
        sort();
    }

    public void getResult(int place){
        try {
            if (place < 1 || place > result.size()) {
                throw new MyException("Не корректное число участников");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
            return;
        }
        LocalTime placeTime = this.sortResult.get(place-1);
        String placeName = this.participants[this.result.indexOf(placeTime)];
        System.out.println(place + "е место: " + placeName + " " + placeTime);
    }

    private void sort(){
        this.sortResult = new ArrayList<>(result);
        Collections.sort(this.sortResult, new Comparator<LocalTime>() {
            @Override
            public int compare(LocalTime o1, LocalTime o2) {
                return o1.compareTo(o2);
            }
        });
    }

}
