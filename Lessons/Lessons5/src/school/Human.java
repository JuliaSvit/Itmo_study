package school;

public interface Human {  /// в интерфейсе хранятся не раелизованные методы
    void setName(String name);
    String getName();

    default boolean isHuman(){  ///  с 8ки можно в интерфейсе раелизовать дефолтные метод
        return true;
    }

}
///////////////////////////////////////////////////
interface Teacher{
    void teach (Human human);
}
//////////////////////////////////////////////////
interface Pupil{
    void study();
}
//////////////////////////////////////////////////
class FirstYearPupil implements Pupil, Human{

    private String name;

    @Override
    public void setName(String name){

    }

    @Override
    public String getName (){
        return this.name;
    }

    @Override
    public void study(){

    }
}



///////////////// Абстрактные классы //////////////////
//Могут иметь реализованные методы и не реализованные методы, описывает базовый функционал класса наследника//

    abstract class DomasticAnimal{
        public String getName(){
            return "DomasticAnimal";
        }

        abstract void eat(); // abstract - методы не реализовываются

    }
//////////////////////////////////////////
    class Dog extends DomasticAnimal{

        @Override
        public void eat() {
            System.out.println("Он ест");
        }
    }

//////////////////////////////////////////
class Man implements Human{

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    public void creatMan(){
        Man man = new Man();
        man.isHuman();
    }
}



















