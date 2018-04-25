import interfase.DefaultUser;
import projectEnum.PermisionsEnum;
import projectEnum.StatusEnum;

import java.util.Set;

public class Commands {

    public static void showCommands(DefaultUser user){

    }
//    {
//        System.out.println( CommandsEnum.SHOW.getComand() + " - показать все команды\n" +
//                CommandsEnum.EXIT.getComand() + " - выход из системы\n" +
//                CommandsEnum.CLOSE.getComand() + " - выход из прогаммы");
//    }

    public static void exit(){
        //возвращает на ввод логина пароля
    }

    public static void close(){
        System.exit(0);
    }
    ////////////////////////////////////////


    public static void showAllTasks(Set<Task> list){

        for (Task task: list){
            task.showTask();
        }

    }

    public static Task createTask(DefaultUser userLogin, String taskName){
        return new Task(userLogin,taskName);
    }

    public static void changeTaskState(Task task, StatusEnum status){
        task.setStatus(status);
    }

    public static void deleteTask(Set<Task> list, DefaultUser userDel, String taskDel){
        for(Task task: list){
            DefaultUser user = task.getUser();
            String taskName = task.getTaskName();
            if(user.equals(userDel) && taskName.equals(taskDel)){
                list.remove(task);
                return;
            }
        }
    }

    public static void addWorker(Set<DefaultUser> userList, String userLogin, String password, PermisionsEnum permision) throws Exception {
        DefaultUser user = UserFactory.createUser(userLogin,password,permision);
        userList.add(user);
    }

    public static void removeWorker(Set<DefaultUser> userList, String userLogin){
        for (DefaultUser user: userList){
            if(user.getLogin().equals(userLogin)) {
                userList.remove(user);
                return;
            }
        }

    }
    ///////////////////////////////////////User

    public static void showAllTasks(Set<Task> taskList, String login){
        for (Task task: taskList){
            if (task.getUser().getLogin().equals(login)){
                task.showTask();
            }
        }
    }

    public static void showDone(Set<Task> taskList, StatusEnum status){
        for (Task task: taskList){
            if (task.getStatus().equals(status.getStatus())){
                task.showTask();
            }
        }
    }

    public static void takeTask(Task task){
        task.setStatus(StatusEnum.IN_WORK);
    }

    public static void makeAsDone(Task task){
        task.setStatus(StatusEnum.DONE);
    }
}
