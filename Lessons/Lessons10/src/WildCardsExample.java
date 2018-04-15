public class WildCardsExample {

    public static void main(String[] args) {
        GenericContainer<Integer> intContainer = new GenericContainer<>(null);
        getDouble(intContainer);
    }

//    public static double getDouble(GenericContainer<Number> container){
//        return container.getItemOrDefault(0.0).doubleValue();
//    }


    // upper bound wildcard - ограничиваем принимаемый тип сверху
    // ? - неизвестный тип
    // extends - указывает на ограничение
    // принимаем Number со всеми потомками
    public static double getDouble(GenericContainer<? extends Number> container){
        Number val = container.getItemOrDefault(null);
//         нельзя добавить ничего, кроме null,
//         но можно получить number
        return val == null ? 0.0:val.doubleValue();
    }

    public static void printNum(GenericContainer<? super Number> container){
        // можем добавлять Number и всех его наследников,
        // но получить можем только Object
        Object val = container.getItemOrDefault(0.0);
        System.out.println(val);

    }

}
