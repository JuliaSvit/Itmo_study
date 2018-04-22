import interfase.DefaultUser;
import projectEnum.Status;

import java.util.Set;

public class Admin extends DefaultUser {


    public Admin(String login, String password) throws Exception {
        super(login, password);
    }

    public void showAllTasks(Set<Task> list){

        for (Task task: list){
            String dateEnd = (task.getDateEnd()==null)?"0":task.getDateEnd().toString();
            System.out.println(task.getUserName() + "\n" + task.getTaskName() + " - " +
                    task.getDateBegin() + " - " + dateEnd + " - " + task.getStatus());
        }

    }

    public Task createTask(String userName, String taskName){
        return new Task(userName,taskName);
    }

    public void changeTaskState(Task task, Status status){
        task.setStatus(status);
    }

    public void deleteTask(Set<Task> list, String userName, String taskName){
        for(Task task: list){
            String user = task.getUserName();
            String tName = task.getUserName();
            if(user.equals(userName) && tName.equals(taskName)){
                list.remove(task);
                return;
            }
        }
    }





}
