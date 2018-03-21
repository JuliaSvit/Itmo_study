public class DataType {

    public static void main (String [] args) {

        System.out.println("Hello");

        short a, b, c;          //16 бит (-32768  32768)
        a = 2;
        b = 3;
        //c = a + b; ошибка
        c = (short) (a + b);

        int a1, b1, c1;    // 32 бит ()
        a1 = 9;
        b1 = 4;
        c1 = a1 / b1;
        float c9 = (float)a1 / (float) b1;
        System.out.println(c9);

        long m;  // 64 бит

        float a2, b2, c2;   //32 бит
        a2 = 0.2f; //в конце ставим f или F
        b2 = 0.3f;
        c2 = a2 * b2;
        System.out.println(c2);

        double a3, b3, c3;   //64 бит
        a3 = 0.2;
        b3 = 0.3;
        c3 = a3 * b3;
        System.out.println(c3);

        char char1, char2, char3, char4, char5; //юникод символы 0 - 65536
        char1 = 74;
        char2 = 'a';
        char3 = 118;
        char4 = 97;
        System.out.println("Char: " + char1 + char2 + char3 + char4);
        char5 = '\u0054';
        System.out.println(char5);

        //////////////////////////////////////////////////////////////////////////////////

        int a5 = 100; //число
        Integer a6 = 120; //ссылка на объект

        ////////////////////////////////////// приведение типов


        byte x = Byte.parseByte("100");
        int x1 = Integer.parseInt("100");
        short x2 = Short.parseShort("100");
        long x3 = Long.parseLong("100");
        double x4 = Double.parseDouble("100.9");
        float x5 = Float.parseFloat("100.9");

        //////////////////////////////////////////
        String str1, str2, str3, str4;
        str1 = "STRING";
        str2 = "STRING";

        str3 = new String("STRING");
        str4 = new String("STRING");

        System.out.println (str1 == str2); // одинаковые объекты true
        System.out.println (str3 == str4); // сравниваются ссылки на разные обекты false
        System.out.println (str3.equals(str4)); // сравнение содержимого объекта true


        }


    }
