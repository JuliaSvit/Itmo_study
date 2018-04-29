public class Stack<T> extends LinkedList{

    public void addStack(T value){ //добавить в стек
        this.add(value);
    }

    public Object getElement(){ //возвращвет последний добавленный элемент и удаляет его из стека
        return this.remove(this.size()-1);
    }

    public Object takeElement(){//посмотреть последный добавленный элемент
        return this.get(this.size()-1);
    }

}
