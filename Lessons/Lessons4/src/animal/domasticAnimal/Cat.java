package animal.domasticAnimal;

public class Cat extends DomasticAnimal {

    public Cat(String name){
        super(name);
    }

    @Override
    public void say(){
       // super.say();
        System.out.println("Мяу-мяу");
    }

    // перегруз метода
    public void say(String text){
        System.out.println("Кошечка говорит: " + text);
    }

}
