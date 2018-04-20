package exam;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List {

    private Node<T> last;
    private Node<T> first;
    private int size = 0;

//    public LinkedList(){
//        this.last = new Node<>();
//    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.size; i++){
            if(this.get(i).equals(o)){
             return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size];
        for (int i = 0; i < this.size; i++){
            arr[i] = this.get(i);
        }
        return arr;
    }

    @Override
    public boolean add(Object o) {
        Node<T> node = new Node<>();
        T obj = (T)o;
        node.setValue(obj);
        if(this.size > 0){
            this.last.setNext(node);
            node.setPrevious(this.last);
            if (this.size == 1){
                this.first.setNext(node);
            }
        } else {
            this.first = node;
        }
        this.last = node;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> node = first;
        for(int i=0; i<size(); i++){
            if(node.getValue().equals(o)){
                node.getPrevious().setNext(node.getNext());
                this.size--;
                return true;
            }
            node = this.getByIndex(i).getNext();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private Node getByIndex(int index){
        Node<T> node = this.first;
        try {
            for (int i = 1; i <= index; i++){
                node = node.getNext();
            }
        } catch (NullPointerException e){
            System.out.println("Ошибка");
            return null;
        }
        return node;
    }

    @Override
    public Object get(int index) {
        Node node = getByIndex(index);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        Node<T> node = getByIndex(index);
        Object obj = get(index);
        if (index == 0){
            node.getNext().setPrevious(null);
            this.first = node.getNext();
            this.size--;
            return obj;
        } else if(index == 1){
            this.first.setNext(node.getNext());
        }
        node.getPrevious().setNext(node.getNext());
//        node.getNext().setPrevious(node.getPrevious());
        this.size--;
        return obj;
    }

    @Override
    public int indexOf(Object o) {
        if (size() == 0) return -1;
        Node<T> node = this.first;
         if (first.getValue().equals(o)) {
             return 0;
         }
         if (last.getValue().equals(o)) {
            return size() - 1;
         }
         for (int i = 1; i < size() - 1; i++) {
         node = this.getByIndex(i).getNext();
         if (node.getValue().equals(o)) {
         return i;
             }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (size() == 0) return -1;
        Node<T> node = this.last;
        for(int i = size()-1; i >= 0; i--) {
            if (node.getValue().equals(o)) {
                return i;
            }
            node = getByIndex(i).getPrevious();
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

}
