package alarm;

public class Red implements Alarm {

    private boolean chek = false;
    private static final int TEMP_LIMIT_RED = 600;

    @Override
    public void tempChanged(int temp) {
        if(temp > TEMP_LIMIT_RED && chek == false){
            System.out.println("Red ALARM " + temp + "°C");
            chek = true;
        } else if(temp <= TEMP_LIMIT_RED && chek == true){
            System.out.println("Температура ниже 600°C  - " + temp + "°C");
            chek = false;
        }
    }
}
