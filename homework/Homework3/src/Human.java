
/* Задание № 3 */

public class Human
{
    private final String name;
    private int desFloor;

    public Human(String name, int floor){

        this.name = name;
        this.desFloor = floor;

    }

    public int getFloor(){
        return this.desFloor;
    }

    public String getName(){
        return this.name;
    }

}
