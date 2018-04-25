package projectEnum;

public enum StatusEnum {

    DONE("done"),
    NEW("new"),
    IN_WORK("in work"),
    CHACKED("checked");

    private String statusName;

    StatusEnum(String s){
        this.statusName = s;
    }

    public String getStatus() {
        return this.statusName;
    }
}
