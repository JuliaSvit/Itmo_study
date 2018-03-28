public class Human {
    //////// Переменные

    boolean walking; //по умолчанию false
    private String name;
    private int age;
    Animal animal;

    public Human(String name, int age){ // конструктор
        this.name = name;
        this.age = age;
    }

        public void walk(){
            this.walking = true;
            System.out.println("walking...");
        }

        public void stop (){
            this.walking = false;
            System.out.println("Stop...");
        }

        public String getName (){
        return this.name;
        }

        public void setName(String name){
            this.name = name;
        }

        public int getAge(){
            return this.age;
        }

        public void setAge(int age){
            this.age = age;

        }

        public void addPet(Animal animal){
            this.animal = animal;
        }

    public static void main (String[] agrs){

        Human human = new Human("Sasha", 16);
//        Human human2 = new Human();
//        Human human3 = human2;
        System.out.println(human.getName());
        if (human.walking){
            human.stop();
        } else {
            human.walk();
        }
//        human.name = "Ivan";
        human.setName("Ivan");
        System.out.println(human.getName() + " " + human.getAge() + " лет");
        if (human.walking){
            human.stop();
        } else {
            human.walk();
        }
        Animal cat = new Animal("Имя кошки", "Цвет");
        human.addPet(cat);
    }

}

class Animal{
    String nsme, color;
    int age;

    public Animal (String name, String color){
        this.nsme = name;
        this.color = color;
    }
}