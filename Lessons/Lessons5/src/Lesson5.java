import battle.*;

/*задача
* программа считывает данные из конфигурационного файла
* ключ:значение*/

public class Lesson5 {
    public static void main (String[] srgs){

        Red [] reds = new Red[10];
        White[]whites = new White[10];

        for (int i = 0; i < 10; i++){
            reds[i] = new Red();
            whites[i] = new White();
        }

        Fight f = new Fight();
        f.winner(whites,reds);
        f.fight(whites,reds);
        f.winner(whites,reds);


    }

}
