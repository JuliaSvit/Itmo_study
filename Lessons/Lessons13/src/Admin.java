import interfase.DefaultUser;
import projectEnum.PermisionsEnum;
import projectEnum.StatusEnum;
import testClass.TaskerException;

import java.util.Set;

public class Admin extends DefaultUser {


    public Admin(String login, String password, PermisionsEnum permision) throws TaskerException {
        super(login, password, permision);
    }

}
