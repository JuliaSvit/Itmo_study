package interfase;

import testClass.TaskerException;

public interface UserInterface {

    void setLogin(String str) throws Exception;
    String getLogin();
    void setPassword(String str) throws TaskerException, TaskerException;
    String getPassword();

}
