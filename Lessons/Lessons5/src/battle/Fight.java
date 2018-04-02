package battle;

import java.util.Random;

public class Fight {

    public void fight (Soldier[] whiteArmy, Soldier[] redArmy){

        Random rmd = new Random();
        for (int i = 0; i < 10;i++){
            if (rmd.nextBoolean()){
                whiteArmy[i].attack(redArmy[i]);
            } else {
                redArmy[i].attack(whiteArmy[i]);
            }
        }

    }

    public void winner(Soldier[] whiteArmy, Soldier[] redArmy){
        int white = 0;
        int red = 0;
        for (int i = 0; i < 10;i++){
            if(whiteArmy[i].isAlive()){
                white++;
            }
            if(redArmy[i].isAlive()){
                red++;
            }
        }
        System.out.println("WiteAlive - " + white + ", RedAlive - " + red);
    }

}
