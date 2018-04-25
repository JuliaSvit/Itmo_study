import interfase.DefaultUser;
import projectEnum.CommandsEnum;
import projectEnum.PermisionsEnum;
import testClass.TaskerException;
import testClass.Validator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DataProvider {

    private Scanner scanner;
    private Set<DefaultUser> users = new HashSet<>();
    private Set<Task> tasks = new HashSet<>();

    public DataProvider(){
        this.scanner = new Scanner(System.in);
        try {
            this.users.add(
                    new Admin("admin", "123", PermisionsEnum.ADMIN));
        } catch (TaskerException e) {
            e.printStackTrace();
        }
    }

    public DefaultUser logIn(){
        DefaultUser user = null;
        String pass = null;
        while (true) {
            System.out.println("Введите логин: ");
            String login = scanner.nextLine();
            if(login.equals(CommandsEnum.CLOSE.getComand())){
                Commands.close();
            }
            for (DefaultUser us : this.users) {
                if (login.equals(us.getLogin())) {
                    user = us;
                    pass = us.getPassword();
                    break;
                }
            }
            if (user == null) {
                System.out.println("Такого логина нет\nВведите правильный логин или выйдете из программы.\nДля выхода введите close");
                continue;
            }
            break;
        }

        while (true){
            System.out.println("Введите пароль: ");
            String password = scanner.nextLine();
            if(password.equals(CommandsEnum.CLOSE.getComand())){
                Commands.close();
            }
            if (password.equals(pass)) {
                return user;
            } else {
                System.out.println("Это не правильный пароль\nВведите правильный логин или выйдете из программы.\nДля выхода введите close");
                continue;
            }
        }

    }

    public String runCommand(){
        while (true) {
            System.out.println("Введите команду: ");
            String command = scanner.nextLine();
            if (!Validator.validatorCommands(command)) {
                System.out.println("Такой команды нет. \nСписок доступных команд можно посмотреть по команде show commands");
                continue;
            }
            return command;
        }

    }

}
