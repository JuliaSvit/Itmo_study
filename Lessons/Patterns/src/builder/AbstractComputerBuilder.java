package builder;

public abstract class AbstractComputerBuilder {

    protected Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void createComputer(){
        computer = new Computer();
    }

    public abstract void buildDisplay();
    public abstract void buildSystemBlock();
    public abstract void buildManipulators();

}
