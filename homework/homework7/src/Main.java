import game.Game;
import grep.Grep;
import marathon.MarathonResult;
import worker.TypeOfSalary;
import worker.WorkerAccounting;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args){
////////////////////////////////////////////////////////////
        Grep grep = new Grep();
        grep.enterArg();
//        grep.enterText(); // ввод текста с клавиатуры
        grep.readText(); // чтение с файла
        grep.filterText();
////////////////////////////////////////////////////////////
        Game newGame = new Game();
        newGame.startGame();
////////////////////////////////////////////////////////////
        WorkerAccounting workerAcc = new WorkerAccounting();
        workerAcc.setWorker("Jo",25000, TypeOfSalary.RATE);
        workerAcc.setWorker("Max",20000, TypeOfSalary.RATE);
        workerAcc.setWorker("Toby",150, TypeOfSalary.HOURLY_PAY);
        workerAcc.setWorker("Emma",35000, TypeOfSalary.RATE);
        workerAcc.setWorker("Theo",200, TypeOfSalary.HOURLY_PAY);
        workerAcc.setWorker("Ivy",130, TypeOfSalary.HOURLY_PAY);
        workerAcc.setWorker("Adam",50000, TypeOfSalary.RATE);
        workerAcc.setWorker("Zoe",28000, TypeOfSalary.RATE);
        workerAcc.setWorker("Matilda",20000, TypeOfSalary.RATE);
        workerAcc.setWorker("Bella",225, TypeOfSalary.HOURLY_PAY);

        workerAcc.showAllWorkers();
        System.out.println("----");
        workerAcc.showFirstName(5);
        System.out.println("----");
        workerAcc.showLastID(3);
////////////////////////////////////////////////////////////
        String[]participants = {"Jo","Nick","Jack","Michael","Max","Bob","Toby","Theo","Evan","Adam"};
        LocalTime[]time = {
                LocalTime.of(2,15,10),
                LocalTime.of(2,15,10),
                LocalTime.of(1,59,44),
                LocalTime.of(1,47,10),
                LocalTime.of(2,0,10),
                LocalTime.of(2,3,35),
                LocalTime.of(1,50,55),
                LocalTime.of(3,11,18),
                LocalTime.of(2,25,14),
                LocalTime.of(2,48,21)
        };

        MarathonResult marathon = new MarathonResult(participants,time);
        marathon.getResult(1);
        marathon.getResult(2);
        marathon.getResult(12);

    }

}
