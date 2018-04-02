package battle;

import java.util.Random;

public class White extends Soldier {

    int boost;

    public White() {
        super(25, 18);
        Random random = new Random();
        this.boost = 10 + random.nextInt(10);
    }

    @Override
    void attack(Soldier enemy) {
        enemy.health -= this.attackScore + boost;
    }

}
