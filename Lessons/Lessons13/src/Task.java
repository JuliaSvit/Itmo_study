import interfase.DefaultUser;
import projectEnum.Status;

import java.util.Date;
import java.util.Objects;

public class Task {

    private DefaultUser user;
    private String taskName;
    private final Date dateBegin;
    private Date dateEnd;
    private Status status;

    public Task(DefaultUser userLogin, String taskName){
        this.user = userLogin;
        this.taskName = taskName;
        this.dateBegin = new Date(); // при создании объекта автоматически заполняется текущей датой
        this.status = Status.NEW;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public String getStatus() {
        return status.getStatus();
    }

    public void setDateEnd(){
        this.dateEnd = new Date();
    }

    public String getDateEnd() {
        return dateEnd.toString();
    }

    public void setNullDateEnd(){
        this.dateEnd = null;
    }

    public void setUserName(DefaultUser userLogin) {
        this.user = userLogin;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public DefaultUser getUser() {
        return this.user;
    }

    public String getDateBegin() {
        return dateBegin.toString();
    }

    public void showTask(){
        String dateEnd = (this.dateEnd==null)?"0":this.dateEnd.toString();
        System.out.println(this.user + " - " + this.taskName +
                " - " + this.dateBegin.toString() + " - " + dateEnd + " - " + this.status.getStatus());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(this.user, task.user) &&
                Objects.equals(this.taskName, task.taskName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, taskName);
    }
}
