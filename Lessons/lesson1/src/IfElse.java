public class IfElse {

    public static void main (String [] args){
        System.out.println("Ветвление");

        // if [else if else]

        boolean condition = false;
        if (condition) {
            System.out.println("condition = true");
        }
        else System.out.println("condition = false");

        int a = 4;
        int b = 6;
        if (a < b) {
            System.out.println("a < b");
        }
        else if (a > b) {
            System.out.println("a > b");
        }
        else {
            System.out.println("a = b");
        }

        // AND &&, OR ||, XOR ^ (если один не true - выполняется), !

        //////////////////////////////////////////
        int day = 1;
        switch (day){
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            //....
            default:
                System.out.println("Неизвестный день");
        }

        /////////////////////////////////////
        //тарнарный оператор
        int num = 13;
        String type = num % 2 == 0 ? "even": "odd"; // переменная = условие ? true:false
        System.out.println(type);


        // Циклы
        // while

        int n = 0;
        while (n < 5){
             //System.out.println(n);
             n = n + 1;
        }

        for (int i = 0; i < 10; i++){
//            System.out.println(i);
        }

        for (int i = 1; i < 10; i+=2){
//            System.out.println(i);
        }

        // do while

        int j = 5;
        do {
            System.out.println(j);
            j--;
        } while (j >= 1);


        // break outer - выход из всех циклов

        int m = 78;
        System.out.println(m/10 + m%10);

        int v = 785;
        System.out.println(v%100/10 + v%100%10 + v/100);



    }

}
