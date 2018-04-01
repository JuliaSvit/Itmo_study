package school;

import lib.MyDate;

import java.util.ArrayList;

public class Pupil extends Human {

    private ArrayList<Integer> rating; //общие оценки
    private int missLesson; //пропущенные уроки
    private String hisGroup = "";
    //можно добавить успеваемость по предметам

    public Pupil(String name, MyDate birthday, String status, boolean sex){
        super(name,birthday,status,sex);
    }

    public Pupil(String name, MyDate birthday, String status, boolean sex, String hisGroup){
        super(name,birthday,status,sex);
        this.hisGroup = hisGroup;
    }

    public void setRating(int rating){
        this.rating.add(rating);
    }

    public ArrayList getRating(){
        return this.rating;
    }

    public void setMissLesson(int missLesson){
            this.missLesson += missLesson;
    }

    public int getMissLesson(){
        return this.missLesson;
    }

    public String getHisGroup(){
        return this.hisGroup;
    }

    public void setHisGroup(String group){

    }
}
