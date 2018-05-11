package alarm;

public class Green implements Alarm {

    private boolean chek = false;
    private static final int TEMP_LIMIT_GREEN = 100;

    @Override
    public void tempChanged(int temp) {
        if(temp > TEMP_LIMIT_GREEN && chek == false){
            System.out.println("Green ALARM " + temp + "°C");
            chek = true;
        } else if(temp <= TEMP_LIMIT_GREEN && chek == true){
            System.out.println("Температура ниже 100°C  - " + temp + "°C");
            chek = false;
        }
    }
}
