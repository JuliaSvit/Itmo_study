public class TestClass {

    public static boolean duplicateTest(String text){

        System.out.println("Проверка duplicate: ");

        return printMessError(text.replaceAll("[0-9 ]", "").isEmpty(), "Присутствуют не только цифры")&&

                printMessError(!text.isEmpty(), "Строка пустая");

    }


    public static boolean goodsListTest(String [] str){

        System.out.println("Проверка goodsList: ");

        if (printMessError(str.length == 3, "Больше или меньше 3х значений.")){

            return(printMessError(str[0].replaceAll("[a-zA-Z]{2,}", "").isEmpty(),"В имени клиента лишние символы или меньше 2х букв!")&&

                    printMessError(str[1].replaceAll("[a-zA-Z0-9]{3,}", "").isEmpty(),"В наименовании товара лишние символы или меньше 3х символов")&&

                    printMessError(!str[1].replaceAll("[0-9]", "").isEmpty(),"В наименовании товара одни цифры")&&

                    printMessError(str[2].replaceAll("[0-9]", "").isEmpty(),"В количестве товара лишние символы"));

        }

        return false;

    }


    private static boolean printMessError(boolean b, String mess){

        if(!b){

            System.out.println("Ввели не правильные данные: " + mess);

        }

        return b;

    }

}
