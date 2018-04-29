public class Queue<T> extends LinkedList{

    public void addToQueue(T value) {//добавление в конец очереди
        this.add(value);
    }

    public Object getElement(){//возвращвет первый элемент и удаляет его из очереди
        return this.remove(0);
    }

    public Object takeElement(){//возвращвет первый элемент в очереди
        return this.get(0);
    }

}
