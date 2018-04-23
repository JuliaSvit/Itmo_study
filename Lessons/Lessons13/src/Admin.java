import interfase.DefaultUser;
import projectEnum.PermisionsEnum;
import projectEnum.Status;
import testClass.TaskerException;

import java.util.Set;

public class Admin extends DefaultUser {


    public Admin(String login, String password, PermisionsEnum permision) throws TaskerException {
        super(login, password, permision);
    }

    @Override
    public void showCommands() {

    }

    public void showAllTasks(Set<Task> list){

        for (Task task: list){
            task.showTask();
        }

    }

    public Task createTask(DefaultUser userLogin, String taskName){
        return new Task(userLogin,taskName);
    }

    public void changeTaskState(Task task, Status status){
        task.setStatus(status);
    }

    public void deleteTask(Set<Task> list, DefaultUser userDel, String taskDel){
        for(Task task: list){
            DefaultUser user = task.getUser();
            String taskName = task.getTaskName();
            if(user.equals(userDel) && taskName.equals(taskDel)){
                list.remove(task);
                return;
            }
        }
    }

    public void addWorker(Set<DefaultUser> userList, String userLogin, String password,PermisionsEnum permision) throws Exception {
        DefaultUser user = UserFactory.createUser(userLogin,password,permision);
        userList.add(user);
    }

    public void removeWorker(Set<DefaultUser> userList, String userLogin){
        for (DefaultUser user: userList){
            if(user.getLogin().equals(userLogin)) {
                userList.remove(user);
                return;
            }
        }

    }
}
