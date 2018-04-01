package school;
import java.util.ArrayList;

public class House{
    private final int floor;
    private final int flatOnFloor;
    private final String address;
    private int [][] fullness;
    ArrayList<Human> humans = new ArrayList<>();

    protected House(String address, int floor,int flatOnFloor){
        this.address = address;
        this.floor = floor;
        this.flatOnFloor = flatOnFloor;
        this.fullness = new int [floor][2];
        for(int i = 0; i < floor; i++){
            this.fullness[i][0] = i+1;
            this.fullness[i][1] = flatOnFloor;
        }

    }

    protected int getFlatOnFloor(){
        return this.flatOnFloor;
    }

    protected int getFloor(){
        return this.floor;
    }

    protected String getAddress (){
        return this.address;
    }

    protected ArrayList<Human> getAllHumans(){
        return this.humans;
    }

    protected void addList(ArrayList<Human> humans){
        int x = this.floor * this.flatOnFloor;
        for(Human h: humans){
            if(x < humans.size() + this.humans.size()){
                System.out.println(h.getName() +  " не влазит");
                break;
            } else {
                this.humans.add(h);
            }
        }
    }
    protected void addPerson(Human human){
        int x = this.floor * this.flatOnFloor;
        if(x < humans.size()+1){
            System.out.println(human.getName() +  " не влазит");
        } else {
            this.humans.add(human);
        }
    }
}
