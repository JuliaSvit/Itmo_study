package school;


import lib.MyDate;

public class Teacher extends Human {

    private String discipline;
    private String haveClass = "";

    public Teacher(String name, MyDate birthday, String status, boolean sex, String discipline){
        super(name,birthday,status,sex);
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setHaveClass(String haveClass) {
        this.haveClass = haveClass;
    }

    public String getHaveClass(){
        return this.haveClass;
    }

}
