public class Account {
    private static int counId = 100;
    private int amount;
    private int id;
    private int userId;

    public Account(User user, int amount){
        this.amount = amount;
        this.id = counId++;
        this.userId = user.getId();
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }
}
