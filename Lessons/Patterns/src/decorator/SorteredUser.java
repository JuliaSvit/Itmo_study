package decorator;

public class SorteredUser extends User implements Comparable<User>{


    private final User user;

    public SorteredUser(User user) {
        super(null, null);

        if (user == null) {
            throw new NullPointerException("user cannot be null");
        }

        this.user = user;
    }



    @Override
    public int compareTo(User o) {
        if (o == null) return 1;
        int surnameCmp = compareString(getSurname(), o.getName());
        if (surnameCmp != 0) return surnameCmp;
        return compareString(getName(), o.getSurname());
    }

    private int compareString(String str1, String str2){
        if (str1 == null && str2 == null) return 0;
        if (str1 != null && str2 == null) return 1;
        if (str1 == null) return -1;

        return str1.compareTo(str2);
    }

    @Override
    public String getName() {
        return user.getName();
    }

    @Override
    public String getSurname() {
        return user.getSurname();
    }

    @Override
    public String toString() {
        return user.toString();
    }
}