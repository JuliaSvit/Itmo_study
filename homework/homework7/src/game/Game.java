package game;

import myLib.*;

import java.util.Random;

/*2) Создайте простую игру основанную на угадывании букв.
Пользователь должен угадать загаданную букву A-Z введя ее в консоль.
Если пользователь угадал букву программа выведет «Right» и игра закончится,
если нет, то пользователь продолжит вводить буквы.
(Опционально) Вывести «You’re too low»- если пользователь ввел букву меньше загаданной,
«You’re too high»- если пользователь ввел букву больше загаданной*/
public class Game {

    private final char litera;

    public Game(){
        Random r = new Random();
        litera = (char) (r.nextInt(26) + 65);
    }

    public void startGame(){
        System.out.println("Угадай какую букву я загадал (A-Z)!!!   " + litera);
        while (true){
            char answer = 0;
            try {
                answer = Reader.readChar();
            } catch (MyException e){
                System.out.println(e.getMessage());
                continue;
            }
            if (answer == litera){
                System.out.println("Right!");
                System.exit(0);
            }
            if(answer > litera){
                System.out.println("You’re too high");
            } else {
                System.out.println("You’re too low");
            }
        }
    }

}
