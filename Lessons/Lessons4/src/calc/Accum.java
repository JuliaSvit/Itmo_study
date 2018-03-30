package calc;

public class Accum {
    private int value;
    private Operation op;

    public Accum (Operation op, int value){
        this.op = op;
        this.value = value;
    }
    public void accum(int a){
        this.value = op.execute(this.value, a);
    }

    public int getValue(){
        return this.value;
    }
}
