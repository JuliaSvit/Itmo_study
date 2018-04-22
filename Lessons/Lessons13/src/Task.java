import projectEnum.Status;

import java.util.Date;

public class Task {

    private String userName;
    private String taskName;
    private final Date dateBegin;
    private Date dateEnd;
    private Status status;

    public Task(String userName, String taskName){
        this.userName = userName;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public String getUserName() {
        return userName;
    }

    public String getDateBegin() {
        return dateBegin.toString();
    }
}
