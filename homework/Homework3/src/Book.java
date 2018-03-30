
/* Задание № 1 */

public class Book {
    private String author;
    private String title;
    private int pagesNum;
    private int bookQuantity = 0; // количество книг одного вида

    public Book(String author,String title,int pagesNum){
        this.author = author;
        this.title = title;
        this.pagesNum = pagesNum;
    }

    public void addBook(int quantity){
        this.bookQuantity += quantity;
    }

    public int takeBook (int quantity){
        int l = this.bookQuantity - quantity;
        if(l < 0){
            System.out.println(quantity + " книг " + this.getBookInfo() +" нет, можно взять только " + bookQuantity);
            this.bookQuantity = 0;
            return l*(-1);
        }else{
            this.bookQuantity -= quantity;
            return 0;
        }
    }

    public String getBookInfo(){
        return this.author + " \"" +this.title + "\"";
    }

}
