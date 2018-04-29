package decorator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class DecoratorUse {

    private static final String[]NAMES = {
            "Nick", "Fred", "Jack", "Paul", "Robert"
    };

    public static void main(String[] args) {
        Collection<User> users = getUser();
        System.out.println(users);

        users = decorete(users);
        System.out.println(users);
    }

    private static Collection<User> decorete(
            Collection<User> users
    ){
        Collection<User> sortedUsers = new TreeSet<>();

        for (User user: users){
            sortedUsers.add(new SorteredUser(user));
        }
        return sortedUsers;
    }

    private static Collection<User> getUser(){
        Collection<User> user = new ArrayList<>(NAMES.length);

        for (int i = 0; i < NAMES.length; i++){
            user.add(new User(NAMES[i],NAMES[NAMES.length-i-1] + "son"));
        }
        return  user;
    }

}
