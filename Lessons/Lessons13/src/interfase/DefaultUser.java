package interfase;

import projectEnum.*;
import testClass.*;

public abstract class DefaultUser extends Throwable implements UserInterface{

    private String login;
    private String password;

    public DefaultUser(String login,String password) throws Exception{
        setLogin(login);
        setPassword(password);
    }

    @Override
    public void setLogin(String login) throws TaskerException {
        if(!Validator.validatorLogin(login)) {
            throw new TaskerException(ExceptionEnum.INVALID_LOGIN.getExceptionText());
        } else {
            this.login = login;
        }
    }

    @Override
    public String getLogin() {
        return this.login;
    }


    @Override
    public void setPassword(String password) throws TaskerException {
        if(!Validator.validatorPassword(password)) {
            throw new TaskerException(ExceptionEnum.INVALID_PASSWORD.getExceptionText());
        } else {
            this.password = password;
        }
    }

    @Override
    public String getPassword() {

        return this.password;
    }

    public void showCommands(){
        System.out.println( Commands.SHOW.getComand() + " - показать все команды\n" +
                Commands.EXIT.getComand() + " - выход из системы\n" +
                Commands.CLOSE.getComand() + " - выход из прогаммы");
    }

    public void exitProgramm(){
        //возвращает на ввод логина пароля
    }

    public void closeProgramm(){
        System.exit(0);
    }

}
