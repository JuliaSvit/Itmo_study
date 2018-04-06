public class Lesson7 {

    public static void main (String []args){

        OneObject oneObject = OneObject.getThisObject();

    }

    public void someString (String ...strings){ //перинимает разное количество параметров (массив строк [])
        for (String str: strings){

        }
    }

    public void someVoid(){
        someString("1","2");
        someString("1");
        someString("1","2","3");
    }

}

class OneObject{  // Такая раелизация коструктора и метода OneObject
    // позваляет создать лишь один экземпляр объекта этого класса,
    // а в дальнейшем вызов метода OneObject будет лишь создавать ссылки на этот объект.
    private OneObject(){

    }
    private static OneObject oneObject = new OneObject();
    public static OneObject getThisObject(){
        return new OneObject();
    }

}
