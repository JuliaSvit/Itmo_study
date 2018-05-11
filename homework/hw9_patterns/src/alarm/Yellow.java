package alarm;

public class Yellow implements Alarm {

    private boolean chek = false;
    private static final int TEMP_LIMIT_YELLOW = 300;

    @Override
    public void tempChanged(int temp) {
        if(temp > TEMP_LIMIT_YELLOW && chek == false){
            System.out.println("Yellow ALARM " + temp + "°C");
            chek = true;
        } else if(temp <= TEMP_LIMIT_YELLOW && chek == true){
            System.out.println("Температура ниже 300°C  - " + temp + "°C");
            chek = false;
        }
    }
}
