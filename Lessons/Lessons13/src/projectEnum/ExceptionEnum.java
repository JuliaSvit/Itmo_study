package projectEnum;

public enum ExceptionEnum {
    INVALID_LOGIN("Ошибка логина"),
    INVALID_PASSWORD("Ошибка пароля");

    private String exceptionText;

    ExceptionEnum(String s) {
        this.exceptionText = s;
    }
    public String getExceptionText(){
        return this.exceptionText;
    }
}
