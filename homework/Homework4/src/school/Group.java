package school;

import java.util.ArrayList;

public class Group {

    private String classNum;
    private Teacher classTeacher;
    private ArrayList <Pupil> listGroup = new ArrayList<>();
    // ещё можно добавить расписание

    public Group(String classNum, Teacher classTeacher){
        this.classNum = classNum;
        this.classTeacher = classTeacher;
    }

    public String getClassNum() { // получить номер класса
        return classNum;
    }

    public int getNumClass(){
        return Integer.parseInt(this.classNum.replaceAll("\\D",""));
    }

    public String getLiteraClass(){
        return this.classNum.replaceAll("\\d","");
    }

    public void setClassNum(String classNum){ // установить номер класса
        this.classNum = classNum;
    }

    public Teacher getClassTeacher() { // получить классного руководителя
        return classTeacher;
    }

    public void setClassTeacher(Teacher classTeacher){ //назначить классного руководителя
        this.classTeacher = classTeacher;
    }

    public void newPupil(Pupil pupil){ // новый ученик в классе
        this.listGroup.add(pupil);
    }

    public void setNewPupils(ArrayList<Pupil> pupils){
        for (Pupil p: pupils){
            this.listGroup.add(p);
        }
    }

    public void excludePupil(Pupil pupil){ // исключение ученика из класса
        this.listGroup.remove(pupil);
    }

    public void excludeAllPupil(){ // выпуск класса
        this.listGroup.clear();
    }

    public ArrayList<Pupil> getPupil (){ // получить список класса
        return this.listGroup;
    }

}
