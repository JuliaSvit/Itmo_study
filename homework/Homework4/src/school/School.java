package school;

import lib.MyDate;

import java.util.ArrayList;

public class School extends House {

    private static final int modAge = 6;
    private int pupInClass; //возможное количество учеников в классе
    private String nameSchool;
    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<Pupil> pupilsWithoutGroup = new ArrayList<>(); //не распределённые учиники
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Pupil> graduatePupils = new ArrayList<>(); // выпускники

    public School(String nameSchool, String address, int floor,int flatOnFloor, int pupInClass){
        super(address,floor,flatOnFloor);
        this.nameSchool = nameSchool;
        this.pupInClass = pupInClass;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void getTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }

    public void setGroup(String classNum, Teacher classTeacher){//создать класс
        if(this.teachers.indexOf(classTeacher) < 0){            // есть ли такой учитель в школе
            System.out.println("Учитель " + classTeacher.getName() + " не работает в " + this.nameSchool);
        } else if (!classTeacher.getHaveClass().isEmpty()){     // ведёт ли учитель другой класс
            System.out.println("Учитель " + classTeacher.getName() + " уже ведёт класс " + classTeacher.getHaveClass());
        } else {
                this.groups.add(new Group(classNum, classTeacher));
                classTeacher.setHaveClass(classNum);
        }
    }

    public ArrayList<Group> getGroups() { // получить список класов
        return groups;
    }

    public void enroll(Pupil pupil){//регистрация ученика
        this.pupilsWithoutGroup.add(pupil);
    }

    public ArrayList<Pupil> getPupilsWithoutGroup() { //получить список не распределённых учеников
        return pupilsWithoutGroup;
    }

    public void graduate(Pupil pupil){// отчисление

    }

    public void graduateGroup(Group group){//выпуск класса
        for (Pupil p: group.getPupil()){
            p.setHisGroup("");
            p.setStatus("Выпускник");
            this.graduatePupils.add(p);
        }
        group.excludeAllPupil();
    }

    public void enrollInGroup(Pupil pupil){  // зачиление в класс
        System.out.println("Зачисление в класс ученика " + pupil.getName());
        int age = pupil.getBirthday().intervalDateYear(new MyDate("01.04.2018"));
        boolean tr = true;
        if (age - modAge >= 1 && age - modAge <= 11) {
            for (Group g : groups) {
                if (g.getNumClass() == age - modAge && g.getPupil().size() < this.pupInClass) {
                    pupil.setHisGroup(g.getClassNum());
                    g.newPupil(pupil);
                    this.pupilsWithoutGroup.remove(pupil);
                    tr = false;
                    System.out.println("Зачислен в " + g.getClassNum());
                    break;
                }
            }
            if (tr){System.out.println("Нет мест");}
        }else {System.out.println("Не подходит по возрасту!");}
    }

    public void transferInGroup(Pupil pupil, Group group){//перевод в другой класс
        if(!pupil.getHisGroup().isEmpty()){
            for (Group g: groups){
                if (g.getClassNum().equals(pupil.getHisGroup())){
                    g.excludePupil(pupil);
                }
            }
        }
        pupil.setHisGroup(group.getClassNum());
        group.newPupil(pupil);
        this.pupilsWithoutGroup.remove(pupil);
    }

    public void transferAllGroup(ArrayList<Group> groups){ //переход в другой класс после окончания учебного года
        for (Group g: groups){
            int x = g.getNumClass();
            String str = g.getLiteraClass();
            if(x == 11){
                graduateGroup(g);
            } else {
                g.setClassNum(x+1 + "str");
            }
        }
    }


}
