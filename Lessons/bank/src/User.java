public class User {
    private static int countId = 1;
    private int id;
    private String email;

    public User(String email){
        this.id = countId++;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
