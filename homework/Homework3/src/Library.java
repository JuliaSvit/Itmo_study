import java.util.ArrayList;

public class Library {
    private ArrayList <Book> book = new ArrayList<>();
    private int count = 0;
    private int MAXBOOK = 100;


    public void put(Book book, int quantity){
        if (count + quantity > MAXBOOK){ // проверка на вместимость
            int last = MAXBOOK - count;
            System.out.println("Все книги " + book.getBook() + " - не поместится.");
            if (last > 0){
                System.out.println("В библиотеку будет добавленно только " + last + " книг из " +
                        quantity);
                this.book.add(book);
                this.book.get(this.book.size()-1).addBook(last);
                count += last;
            }

        }else{
            this.book.add(book);
            this.book.get(this.book.size()-1).addBook(quantity);
            count += quantity;
        }

    }

    public int get(Book book, int quantity){
        int k = this.book.indexOf(book);
        int noGet = this.book.get(k).takeBook(quantity);
        count -= quantity - noGet;
        return noGet;
    }
}
