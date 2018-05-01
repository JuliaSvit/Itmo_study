package worker;

public class HourlyPayWorker extends Worker{

    public HourlyPayWorker(int workerId, String name, double salary) {
        super(workerId, name, salary);
    }

    @Override
    double salaryPerMaonth() {
        return 20.8*8*this.getSalary();
    }
}
