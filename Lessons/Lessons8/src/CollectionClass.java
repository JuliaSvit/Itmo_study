import java.util.*;

public class CollectionClass {

    //Коллекции
//Collection Framework

// 1.    interface Collection

//        int size(); размер
//        boolean isEmpty(); пустой ли
//        boolean contain(Object obj); содержит ли
//        boolean add(elem); добавление элемента
//        boolean remove(Object obj); удаление элемента
//
//        boolean conainsAll(Collection<?> c);
//        boolean addAll(Collection c);
//        boolean removeAll(Collection<?> c);
//        boolean retainAll(Collection<?> c); удаляет все кроме коллекци в аргументе
//        void clear(); удаляет всё

//        for(Object o: collection){ перечесление элементы коллекции
//            System.out.println(o);
//        }

// 1.1  interface Set коллекция которая не может дублирующих элементов

//    - HashSet
//      реализация на основе хеш-таблицы.
//      Это наиболее эффективная реализация,
//      но она не гарантирует сохранение порядка элементов при обходе
//     - LinkedHashSet
//    медленее HashSet
//     - TreeSet
//    медленее LinkedHashSet

// 1.2  interface List - упарядоченная коллекция, которая может содержать дублирующие элементы
//    доступ/удаление/добавление элементов по индексу
//    поиск элементов
//    замена элементов
//    операции с частью списка
//    есть расширенный итератор ListIterator
        ArrayList<String>arrLst = new ArrayList<>();
        LinkedList<String>linkedList = new LinkedList<>(); //есть ссылки на соседние элементы

// 1.3  interface Queue
// однонапрвленная
//    element(); возвращает, но НЕ удаляет элемент из начала очереди (при пустой очереди будет ошибка)
//    peek(); возвращает без удаления элемент из начала очереди (при пустой очереди вернёт null)
//    remove(); возвращает и удаляет элемент из начала очереди (при пустой очереди будет ошибка)
//    poll(); возвращает и удаляет элемент из начала очереди (при пустой очереди вернёт null)
//    addFirst();
//    addLast();
//    getFirst();
//    getLast();
        Queue<String> queue1 = new PriorityQueue<>();
        Queue<String> queue2 = new ArrayDeque<>();


//
//
//


    }
