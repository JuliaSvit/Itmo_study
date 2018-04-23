import interfase.DefaultUser;
import projectEnum.PermisionsEnum;
import projectEnum.Status;

import java.util.Set;

public class User extends DefaultUser {

    public User(String login, String password, PermisionsEnum permision) throws Exception {
        super(login, password,permision);
    }

    @Override
    public void showCommands() {

    }

    public void showAllTasks(Set<Task> taskList){
        for (Task task: taskList){
            if (task.getUser().getLogin().equals(this.getLogin())){
                task.showTask();
            }
        }
    }

    public void showDone(Set<Task> taskList, Status status){
        for (Task task: taskList){
            if (task.getStatus().equals(status.getStatus())){
                task.showTask();
            }
        }
    }

    public void takeTask(Task task){
        task.setStatus(Status.IN_WORK);
    }

    public void makeAsDone(Task task){
        task.setStatus(Status.DONE);
    }

}
