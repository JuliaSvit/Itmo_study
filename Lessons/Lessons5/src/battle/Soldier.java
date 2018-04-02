package battle;

abstract class Soldier {
    protected int health;       //здоровье
    protected int attackScore;  //урон

    public Soldier(int health, int attackScore) {
        this.health = health;
        this.attackScore = attackScore;
    }

    public boolean isAlive(){
        return this.health > 0;
    }

    abstract void attack(Soldier enemy);
}
