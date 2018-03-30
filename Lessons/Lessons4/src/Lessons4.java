import animal.domasticAnimal.*;
import animal.wildAnimal.Animal;
import calc.*;

public class Lessons4 {
    //////////// наследование классов

    // наследоваться можно только от одно класса
    public static void main(String [] args ){

        /*DomasticAnimal da = new DomasticAnimal("DomAnimals");
        da.say();
        da.liveWithPeople();
        da.name = "new  name";

        Dog dog = new Dog("Бобик");
        dog.say();
        dog.liveWithPeople();

        Cat cat = new Cat("Пушок");
        cat.say();
        cat.say("Мур");
        cat.liveWithPeople();*/

        /*    //// полиморфизм наследования
        Animal animal1 = new Cat("Мурзик");
        animal1.say();
        Animal animal2 = new Dog("Шарик");
        animal2.say();
        //animal2.liveWithPeople(); // не можем пользоваться методами не определёнными в родительским классе (animal.wildAnimal.Animal);
        */

        Accum acc = new Accum(new Sum(),3);
        System.out.println(acc.getValue());
        acc.accum(5);
        System.out.println(acc.getValue());

    }

    //////////////////////////////////////////////////////////////////////////////////////

    //// Модификаторы доступа

//        public - виден везде
//        protected  - виден только в рамках пакетаб где находится класс и наследникам из любого пакета
//        private - виден только в рамках своего класса
//        default (без модификатора) - виден только в рамках своего пакета

}
