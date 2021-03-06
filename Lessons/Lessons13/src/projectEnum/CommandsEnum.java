package projectEnum;

public enum CommandsEnum {
    SHOW("show commands"),
    EXIT("exit"),
    CLOSE("close"),

    SHOW_ALL_TASKS("show all tasks"),
    CREATE_TASK("create task"),
    CHANGE_TASK_STATUS("change task state"),
    DELETE_TASK("delete task"),
    ADD_WORKER("add worker"),
    REMOVE_WORKER("remove worker"),
    SHOW_DONE("show done"),
    TAKE_TASK("take task"),
    MAKE_AS_DONE("make as done");

    private String com;

    CommandsEnum(String s){
        this.com = s;
    }

    public String getComand() {
        return this.com;
    }
}
