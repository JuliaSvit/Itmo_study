package calc;

public class Sum extends Operation {
//сложение
    @Override
    public int execute(int a, int b){
        System.out.println("Сложение " + (a+b));
        return a+b;
    }

}
