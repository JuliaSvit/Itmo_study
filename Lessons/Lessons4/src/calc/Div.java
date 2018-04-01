package calc;

public class Div extends Operation {
//деление
    @Override
    public int execute(int a, int b){
        if (b > 0) {
            return a / b;
        }
        System.out.println("На ноль делить нельзя");
        return 0;
    }
}
