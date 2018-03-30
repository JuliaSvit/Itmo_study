package animal.domasticAnimal;

public class Dog extends DomasticAnimal {

    public Dog (String name){
        super(name);
    }

    @Override //переопределение родительского метода
    public void say(){
       // super.say(); // вызывает родительский метод(если нужно оставить родительский функцилнал и добавить новое)
        System.out.println("Гав-гав");
    }


}
