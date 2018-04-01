package school;


import lib.MyDate;

public class Human {

    private String name;
    private MyDate birthday; //нужна проверка ввода
    private String status; // ученик, учитель, родитель, директор (можно сделать enum)
    private boolean sex; //пол true - мальчик, false - девочка

    protected Human (String name, MyDate birthday,String status, boolean sex){
        this.name = name;
        this.birthday = birthday;
        this.status = status;
        this.sex = sex;
    }

    protected void talk(){
        System.out.println("Привет");
    }

    public String getName(){
        return this.name;
    }

    protected MyDate getBirthday(){
        return this.birthday;
    }

    protected String getStatus(){
        return this.status;
    }

    protected void setStatus(String status){
        this.status = status;
    }
}
