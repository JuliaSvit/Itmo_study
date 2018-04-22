package projectEnum;

public enum Status {

    DONE("done"),
    NEW("new"),
    IN_WORK("in work"),
    CHACKED("checked");

    private String statusName;

    Status(String s){
        this.statusName = s;
    }

    public String getStatus() {
        return this.statusName;
    }
}
