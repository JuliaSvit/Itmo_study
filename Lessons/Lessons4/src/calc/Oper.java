package calc;

public class Oper {
    public int plus(int a, int b, char ch){
        int res = 0;
        switch (ch) {
            case '+': res = a + b;
                    break;
            case '-': res = a - b;
                break;
            case '*': res = a * b;
                break;
            case '/': res = a / b;
                break;
        }
        return res;
    }
}
