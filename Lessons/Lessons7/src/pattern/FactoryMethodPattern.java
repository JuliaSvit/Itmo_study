package pattern;
/*
* Определяет интерфейс для создания, но оставляет подклассам решение
* в какой класс инсталировать.
* Фабричный метод позволяет классу делегировать создание подклассов.
* Используется когда:
* - классу заранее неизвестно, объекы каких подклассов нужно создать;
* - класс спроекторован так, что бы объекты, которые он создаёт,
* специфицировалирь подклассами;
* - класс делегирует свои обязаности одному из нескольких вспомогательных
* подклассов, и планируется локализовать заранее о том,
* какой подкласс принимает на себя эти обязаности.
*/

public class FactoryMethodPattern {

    public FactoryMethodPattern(){

    }



}

interface ParentInterface{
    void parentClassVoid();

}

class FactoryPattern{
    public static ParentInterface getChild(boolean condition){
        if (condition){
            return new ChildClass1();
        } else {
            return new ChildClass2();
        }

    }
}

class ChildClass1 implements ParentInterface{

    @Override
    public void parentClassVoid() {

    }
}

class ChildClass2 implements ParentInterface{
    @Override
    public void parentClassVoid() {

    }
        }
