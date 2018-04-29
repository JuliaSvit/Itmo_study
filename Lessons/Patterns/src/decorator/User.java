package decorator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private static final DateFormat FORMAT =
            new SimpleDateFormat("yyyy-dd-MM HH:mm");

    private final String name;
    private final String surname;
    private final long registered;

    public User(String name, String surname){
        this.name = name;
        this.surname =surname;
        this.registered = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                FORMAT.format(new Date(registered));
    }
}
