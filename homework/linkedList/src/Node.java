
public class Node<T> {
    private T value;
    private Node next;
    private Node previous;

    public Node(){
        this.next = null;
        this.previous = null;
    }

    public Node(Node previous){
        this.next = null;
        this.previous = previous;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass()!= obj.getClass()){
            return false;
        }
        Node temp = (Node)obj;
        return this.value.equals(temp.getValue());
    }


}
