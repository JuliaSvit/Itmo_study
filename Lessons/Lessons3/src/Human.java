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
            if (!this.walking){
                System.out.println("Walking...");
                this.walking = true;
            } else {
                System.out.println("Already walking");
            }
        }

        public void stop (){
            if (this.walking){
                System.out.println("Stop...");
                this.walking = false;
            } else {
                System.out.println("Already stop...");
            }
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

        human.stop();
        human.walk();

//        human.name = "Ivan";
        human.setName("Ivan");
        System.out.println(human.getName() + " " + human.getAge() + " лет");
        Animal cat = new Animal("Имя кошки", "Цвет");
        human.addPet(cat);
        human.walk();
        human.stop();
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