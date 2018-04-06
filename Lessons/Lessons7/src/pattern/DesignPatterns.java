package pattern;

public class DesignPatterns {
    //      Шаблон проекторования (паттерн) -
    //      повторимая архитиктурная конструкция,
    //      пердставляющаясобой решение проблемы проектирования
    //      в рамках некоторых часто возникающего контекста

    /*  Делятся на основные паттерны:
    *   - Порождающие - создают объекты по определённым сценариям;
    *   Singleton
    *   Factory
    *   Abstract Factory
    *   Builder
    *   Prototype
    *
    *   - Структурные - определяют различные сложные структуры,
    *   которые изменяют интерфейс уже существующих объектов или
    *   его реализацию(позаоляют оптимизировать программу);
    *   Adapter
    *   Composite
    *   Facade
    *   Bridge
    *   Decorator
    *   Proxy
    *   Fly Weight
    *
    *   - Поведенчиские - определяют взаимодействия между объектами,
    *   увеличивае его гибкость;
    *   Observer
    *   Visitor
    *   Iterator
    *   Strategy
    *   Command
    *   */



    public static void main (String []args){
        SingletonPattern singletonPattern1 = SingletonPattern.getInstence();
        SingletonPattern singletonPattern2 = SingletonPattern.getInstence();
        SingletonPattern singletonPattern3 = SingletonPattern.getInstence();
        SingletonPattern singletonPattern4 = SingletonPattern.getInstence();
    }


}
//    Одиночка Singleton (2 варианта)
//    У Singleton класса есть только один экземпляр,
//    и он представляет к нему точку доступа
class SingletonPattern{
    // Объект создается в классе
    private static final SingletonPattern INSTENCE = new SingletonPattern();

    // Приватный конструктор
    private SingletonPattern(){

    }

    //
    public static SingletonPattern getInstence(){
        return INSTENCE;
    }
}

class SingletonPattern2{//создаёт объект только после обращения к этому классу

    private static SingletonPattern2 instence;

    private SingletonPattern2(){

    }

    public static SingletonPattern2 getInstence(){
        if (instence == null){
            instence = new SingletonPattern2();
        }
        return instence;
    }
}


//