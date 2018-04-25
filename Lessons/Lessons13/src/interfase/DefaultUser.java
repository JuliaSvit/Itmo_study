package interfase;

import projectEnum.*;
import testClass.*;

import java.util.Objects;

public abstract class DefaultUser extends Throwable implements UserInterface{

    private String login;
    private String password;
    private PermisionsEnum permision;

    public DefaultUser(String login,String password, PermisionsEnum permision) throws TaskerException{
        setLogin(login);
        setPassword(password);
        setPermision(permision);
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

    @Override
    public void setPermision(PermisionsEnum permision) {
        this.permision = permision;
    }

    @Override
    public PermisionsEnum getPermision() {
        return this.permision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUser that = (DefaultUser) o;
        return Objects.equals(this.login, that.login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.login);
    }
}
