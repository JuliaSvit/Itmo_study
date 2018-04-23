import interfase.DefaultUser;
import projectEnum.PermisionsEnum;

public class UserFactory {

    public static DefaultUser createUser(String login, String password, PermisionsEnum permision) throws Exception {
        if(permision.equals(PermisionsEnum.ADMIN)){
            return new Admin(login,password,permision);
        }
        return new User(login,password,permision);
    }
}
