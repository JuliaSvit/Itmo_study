import interfase.DefaultUser;
import projectEnum.PermisionsEnum;
import projectEnum.StatusEnum;

import java.util.Set;

public class User extends DefaultUser {

    public User(String login, String password, PermisionsEnum permision) throws Exception {
        super(login, password,permision);
    }

}
