import hw1.Book;
import hw1.Library;
import hw2.Figure;
import hw3.House;
import hw3.Human;

import java.util.ArrayList;

public class Homework3 {

    public static void main(String [] args){

        Homework3 hm3 = new Homework3();
        System.out.println("\n1. Библиотека.\n");
        hm3.inLibrary();
        System.out.println("\n2. Фигуры.\n");
        hm3.figures();
        System.out.println("\n3. Расселение.\n");
        hm3.houses();
    }

    //////////////////////////////////////////////
    /*1. Сделать библиотеку, которая ведет учет книг. Должно быть как минимум два класса: hw1.Book и hw1.Library.
    hw1.Library имеет два метода: void put(hw1.Book book, int quantity) и int get(hw1.Book book, int quantity).
    Каждой книге в библиотеке соответствует счетчик, показывающий количество хранящихся книг,
    при добавлении книги - счетчик увеличивается, при извлечении - уменьшается на число quantity.
    Поля класса hw1.Book: author, title, pagesNum.
    Библиотека хранит ограниченное число книг, сколько - на ваше усмотрение.*/

    public void inLibrary(){

        Library lib = new Library();
        Book book = new Book ("Джек Лондон","Зов предков",320);
        Book book1 = new Book("Ромен Гари", "Корни неба", 576);
        Book book2 = new Book("Александр Молчанов", "Писатель", 320);
        Book book3 = new Book("Иван Тургенев", "Отцы и дети", 480);
        lib.put (book,20);
        lib.put(book1,10);
        lib.put(book2,25);
        lib.put(book3,20);
        lib.put(new Book("Джек Лондон", "Мартин Иден", 416),15);
        lib.put(new Book("Уильям Шекспир", "Комедии", 512),15);

        int read1 = lib.get(book,11);
        if (read1 > 0) {
            System.out.println("Не хватило " + read1 + " книг");
        } else {
            System.out.println(book.getBookInfo() + " хватит всем");
        }
        int read2 = lib.get(book1,15);
        if (read2 > 0) {
            System.out.println("Не хватило " + read2 + " книг");
        }else {
            System.out.println(book2.getBookInfo() + " хватит всем");
        }

    }


    /////////////////////////////////////
    /*2. Создать фигуры: Circle, Rectangle, Triangle, у которых будут координаты.
    Все фигуры должны иметь методы, которые возвращают площадь и периметр
    (для окружности - длина окружности).*/

    public void figures(){
        System.out.println("Это круг");
        int[][] c = {{3,5},{2,-1}};
        Figure circle = new Figure(c);
        System.out.println("его длина окружности равна " + circle.perimeter());
        System.out.println("а его площадь равна " + circle.area());

        System.out.println("\nЭто четырёхугольник");
        int[][] s = {{5,7},{9,7},{10,2},{2,2}};
        Figure square = new Figure(s);
        System.out.println("его периметр равен " + square.perimeter());
        System.out.println("а его площадь равна " + square.area());

        System.out.println("\nЭто треугольник");
        int[][] t = {{5,1},{0,1},{8,8}};
        Figure triangle = new Figure(t);
        System.out.println("его периметр равен " + triangle.perimeter());
        System.out.println("а его площадь равна " + triangle.area());
    }

    /*3. Дом строется со следующими характеристиками:
        Что из низ задается через конструктор, а что потом - решайте сами
        1. какое-то количество подъездов
        2. какое-то количество этажей
        3. какое-то количество квартир на этаже
        4. адрес
        У дома должна быть возможность сообщить, сколько в нем квартир - метод
        У дома должна быть возможность показать адрес - метод
        У дома должна быть возможность сообщить, сколько людей в нем живет - метод

        Есть очередь людей (массив с объектами класса hw3.Human),
        каждый хочет заселиться в дом , но у каждого есть пожелание - этажность дома!

        Одновременно в дом можно заселить троих.
        $house->add(); при вызове этого метода можно заселить только 3х людей

        Людей из списка можно заселять в дом (по квартире на человека),
        если в нем есть еще свободные квартиры
        и если их пожелание можно учесть (желаемый этаж должен быть в доме).

        Если человека нельзя поселить, потому что его пожелание не выполняется,
        он перемещяется в конец очереди.
        Если не хватило места - остается на прежнем месте, ждать нового дома*/

    void houses(){
        // Заполняем очередь людей
        ArrayList<Human> hQ = new ArrayList<>();
        hQ.add(new Human ("Иванов",3));
        hQ.add(new Human ("Петров",10));
        hQ.add(new Human ("Шиатко",1));
        hQ.add(new Human ("Воробушек",5));
        hQ.add(new Human ("Вольва",3));
        hQ.add(new Human ("Отличная",1));
        hQ.add(new Human ("Пушкина",5));
        hQ.add(new Human ("Патин",2));
        hQ.add(new Human ("Губова",4));
        hQ.add(new Human ("Дураков",3));
        hQ.add(new Human("Богиня",1));
        hQ.add(new Human ("Зорькин",2));
        hQ.add(new Human ("Кваша",2));

        //Создаём новый дом
        House house = new House("Пушкинская", 3, 2, 5);

        //Заселяем в него людей
        house.add(hQ);
        house.add(hQ);

        System.out.println("В доме по адресу " + house.getAdres() + " на " + house.getAllFlat() +
                " вартир, проживает " + house.getAllHumans() + " человек");
    }

}
