public class StringWork {

    public static void main (String[]args){

        String str1 = new String("String 2");
        String str = "String";


        /// Форматирование, выводы чисел

        String st = String.format("шаблон со специальными символами %d%n", 3434); //медленно работает
        System.out.println(st);

        StringBuilder sb = new StringBuilder(); // можно менять строковые объекты, длинные строки
        StringBuffer sf = new StringBuffer();   // как StringBuilder, позволяет безопасно работать со множеством потоков,
                                                // требут больше ресурсов

        sb.append("some new ").append("new"); // плюсует
        sb.insert(3, "INSERT");  //вставляет на заданную позицию
        System.out.println(sb);

        String stFromLoop = "";
        for (int i = 0; i < 10; i++){
            stFromLoop += "number" + i; // StringConcatFactory на каждой итерации создаёт новый объект, медленно работае
        }

        System.out.println(stFromLoop);


        StringBuilder sbLoop = new StringBuilder();
        for (int i = 0; i < 10; i++){
            sbLoop.append("number ").append(i); // StringBuilder.append  быстее string
        }
        System.out.println(sbLoop);

        str1.equals(str);
        str1.equalsIgnoreCase(str); //без учёта регистра

        str1.compareTo(str);
        str1.compareToIgnoreCase(str); //  не учитывается регистр
        ///  0, если аргумент (str2) лексически равен строке str1
        //   < 0, если str2 больше str1
        //   > 0, если str2 меньше str1


        //////////// длина строки
        str.length();

        ///////////////////// начинается/заканчивается ли стока с агрумента

        str.startsWith("qwe");
        str.endsWith("wer");

        ////////////////////

    }

    }
