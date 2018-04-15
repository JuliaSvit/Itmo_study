

public class Lesson10 { // дженерики <>
    /**
     * Подход к описаню данных и алгоритмов, который позволяет их использовать
     * с различными типами данных без изменения их описания
     */

    public static void main(String[] args) {
        Container container1 = new Container("Some value");
        Container container2 = new Container(null);
        String str = (String) container1.getItemOrDefault("Default value");
        Integer integer = (Integer) container2.getItemOrDefault(0);
//        Integer integer = (Integer) container2.getItemOrDefault("Def value");
        // ошибка на моменте выполнения программы
        System.out.println(str);
        System.out.println(integer);

        GenericContainer<String> gcont1 = new GenericContainer<>("Some value");
        GenericContainer<Integer> gcont2 = new GenericContainer<>(null);
        String str1 = gcont1.getItemOrDefault("Value");
//        Integer integer1 = gcont2.getItemOrDefault("Some val");
        // ошибка на момента компиляции

//        raw -типы можно не указывать тип при создании объекта, но при присваиваии нужно будет привести к нужному типу
//        GenericContainer gcont3 = new GenericContainer("Some value");
//        GenericContainer gcont4 = new GenericContainer(null);
//        String str5 = (String) gcont1.getItemOrDefault("Value");

        Pair<String,Integer> pair = new Pair<>("key", 4);

//        Женерики соблюдабт правило полиморфизма -
        GenericContainer<Number> numbCount = new GenericContainer<>(null);
        Number number = numbCount.getItemOrDefault(0);
        Number number1 = numbCount.getItemOrDefault(0.0);


    }
}
class Container{
    private Object item;
    public Container(Object item){
        this.item = item;
    }
    public Object getItemOrDefault(Object dflt){
        return item == null ? dflt : item;
    }
}

class GenericContainer<T>{  // в угловых скобках указывается неизвестный тип
    private T item;
    public GenericContainer(T item){
        this.item = item;
    }
    public T getItemOrDefault(T dflt){
        return item == null ? dflt : item;
    }

}

// можно использовать несколько дженериков

class Pair<K,V>{
    private K key;
    private V velue;
    public Pair(K key,V velue){
        this.key = key;
        this.velue = velue;
    }

    public K getKey(){
        return key;
    }

    public V getVelue(){
        return velue;
    }

}
// можно применять для уточнения типа при описании класса,
// что бы использовать специализированные методы
//class GenericNumContainer<T extends Number>{
//    private  T item;
//
//}

// Задание 1
// написасть enum, который печесляет планеты и возвращает массу планеты её радиус и радиус орбиты

// Задание 2
//Node



















