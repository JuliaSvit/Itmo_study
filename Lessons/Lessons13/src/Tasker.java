import interfase.DefaultUser;
import projectEnum.PermisionsEnum;
import testClass.TaskerException;

import java.util.HashSet;
import java.util.Set;

public class Tasker {

    public static void main(String[]args) throws Exception {
//        Set<Task> list = new HashSet<>();
//        try {
//            User user1 = new User("Bob","123456", PermisionsEnum.USER);
//            User user2 = new User("Nick","123456",PermisionsEnum.USER);
//            User user3 = new User("Tod","123456",PermisionsEnum.USER);
//            System.out.println(list.add(new Task(user1, "Work")));
//            System.out.println(list.add(new Task(user2, "Work2")));
//            System.out.println(list.add(new Task(user3, "Work3")));
//            System.out.println(list.add(new Task(user1, "Work")));//false
//        }catch (TaskerException e){
//            System.out.println(e);
//        }
        DataProvider data = new DataProvider();
        DefaultUser user = data.logIn();
        System.out.println(user.getClass().toString().equals("class Admin"));
        System.out.println(user.getLogin());

    }

}
