package battle;

public class Red extends Soldier {

    public Red() {
        super(25, 15);
    }

    @Override
    void attack(Soldier enemy) {
        enemy.health -= this.attackScore + 10;

    }
}
