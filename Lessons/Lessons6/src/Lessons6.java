public class Lessons6 {

    // переменные
    final int finalVar = 9; // нужно инициализировать при объявлении, нельзя изменить.
    public Lessons6(){
//        finalVar = 10; - нельзя изменить.
    }

    public static void main(String[]srgs){

        //finel - переменные
        //методы
        //агрументы методов
        //локальные переменные
        //классы


        // переменные
        final int finalVar = 9; // нужно инициализировать при объявлении, нельзя изменить.
//        finalVar = 10; - нельзя изменить.

    }
    //метод final
    // не может быть переопределен наследником
    final void finalVoid(){
        System.out.println("finalVoid");
    }

    //агрументы методов
    public void someVoid(final int a){

//        a = 9; // изменять нельзя
        //локальные переменные
        final int localVar;
        localVar = 0;
    }

}
    //класс, нельзя наследовать
final class StsticParant {

}

interface SomeClass{
    private void someVoid(){

    }
}


