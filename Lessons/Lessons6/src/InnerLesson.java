
public class InnerLesson {

    public static void main(String [] args){

        OtherClass otherClass = new OtherClass();
        OtherClass.InnerStatic innerStatic = new OtherClass.InnerStatic(); // создаём объект влеженного статического класса через внешний

        OtherClass.InnerClass innerClass = otherClass.new InnerClass(); //  создаем объект влеженного не статического класса через внешний

        Object obj = otherClass.voidWithClass();
//        obj.localVoid(); //нельзя использовать методы локального класса
    }

}

class OtherClass{

    private int notStaticInt = 1;
    private static int staticInt = 2;

    public OtherClass(){
        InnerStatic innerStatic = new InnerStatic();
        System.out.println(innerStatic.innerInt);
        innerStatic.someVoid();
        InnerStatic.someVoid();

        InnerClass innerClass = new InnerClass();
        innerClass.innerVoid();

    }

    public Object voidWithClass(){
////////////////////////////////////////////////////////////////////////////////////
        class LocalClass{   //локальный класс к нему доступ только в пределах этого метода,
                            // классу доступны все переменные внешнего класса
            public Object localVoid() {
                System.out.println(staticInt);
                System.out.println(notStaticInt);
                LocalClass localClass = new LocalClass();
                return localClass;
            }
        }
        return new LocalClass();
    }

//////////////////////////////////////////////////////////////////////////////////////////

// Анонимный класс

    public void createClass (){

        Runnable runnable = new Runnable() {  //анонимный класс, в конце ";"
                                            // вызываем класс и описываем его методы
            @Override
            public void run() {

            }
        };

        runnable.run();

    }

//////////////////////////////////////////////////////////////////////////////////

    //static
    //вложенный класс
    static class InnerStatic{

        private int innerInt;

        public static void someVoid(){
            staticInt ++;   // имеет доступ только к статическим объектам и методам внешнего класса
//            notStaticInt++;
        }

    }

///////////////////////////////////////////////////////////////////////////////////
  //вложенный класс не статический
    public class InnerClass{

        public void innerVoid(){
            System.out.println(notStaticInt); // доступ ко всем переменным внешнего класса
            System.out.println(staticInt);
        }
        // не может содержать статические методы и свойства:
//        public static void staticVoid(){
//
//        }
    }

}

class ChildClass extends OtherClass{
    public void someVoid(){

    }
}





