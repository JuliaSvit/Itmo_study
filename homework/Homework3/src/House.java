
/* Задание № 3 */

import java.util.ArrayList;

public class House{
    private final int floor;
    private final int door;
    private final int flatOnFloor;
    private final String adres;
    private int [][] fullness;
    ArrayList<Human> humans = new ArrayList<>();

    public House(String adres, int floor, int door,int flatOnFloor){
        this.adres = adres;
        this.floor = floor;
        this.door = door;
        this.flatOnFloor = flatOnFloor;
        this.fullness = new int [floor][2];
        for(int i = 0; i < floor; i++){
            this.fullness[i][0] = i+1;
            this.fullness[i][1] = flatOnFloor * door;
        }

    }

    public int getAllFlat(){
        return this.floor * this.flatOnFloor;
    }

    public String getAdres (){
        return this.adres;
    }

    public int getAllHumans(){
        return this.humans.size();
    }

    public void add(ArrayList<Human> humans){
        int count = 0;
        for(int i = 0; i < 3;){
            count++;
            int f = humans.get(0).getFloor();
            if(f > floor || this.fullness[f-1][1] < 0){
                humans.add(humans.get(0));
                humans.remove(0);
                count--;
            }else {
                this.humans.add(humans.get(0));
                humans.remove(0);
                this.fullness[f-1][1]--;
                i++;
                count--;
            }
            if(count >= humans.size()){
                break;
            }
        }
    }
}

