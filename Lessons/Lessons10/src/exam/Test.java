package exam;

import java.util.Arrays;

public class Test {

    public enum Planet {
        Mercury(1354.57,5646.5,4654.25),
        Venus(1354.57,5646.5,4654.25),
        Earth(56.3,5646.5,4654.25),
        Mars(84.3,5646.5,4654.25),
        Jupiter(9354.57,5646.5,4654.25),
        Saturn(5986,5646.5,4654.25),
        Uranus(254.35,5646.5,4654.25),
        Neptune(487.14,5646.5,4654.25),
        Pluto(986.145,5646.5,4654.25),;

        private double mass;
        private double radius;
        private double orbit;

        Planet(double mass,double radius,double orbit){
            this.mass = mass;
            this.radius = radius;
            this.orbit = orbit;
        }

        public String getPlanet() {return "Масса: " + this.mass + " Радиус: " + this.radius +" Орбита: " + this.orbit;}
    }

    public static void main(String[] args) {

        for (Planet s : Planet.values())
            System.out.println(s + ": " + s.getPlanet());

        LinkedList<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(25);
        list.add(50);
        list.add(11);
        list.add(4);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.remove(Integer.valueOf(25)));
        System.out.println(Arrays.toString(list.toArray()));

        LinkedList<String>list1 = new LinkedList<>();
        list1.add("Hello");
        list1.add("World");
        list1.add("And");
        list1.add("By");
        System.out.println(list1.indexOf("jhg"));
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(list1.remove("By"));
        System.out.println(list1.remove(0));
        System.out.println(list1.get(0));
        System.out.println(Arrays.toString(list1.toArray()));

    }


}
