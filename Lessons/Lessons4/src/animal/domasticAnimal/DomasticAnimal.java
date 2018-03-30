package animal.domasticAnimal;

import animal.wildAnimal.Animal;

public class DomasticAnimal extends Animal {

    public DomasticAnimal(String name){
        super(name);
    }
    public void liveWithPeople(){
        System.out.println("Я живу с людьми");
    }
}
