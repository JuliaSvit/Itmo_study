package worker;

public class RateWorker extends Worker{

    public RateWorker(int workerId, String name, double salary) {
        super(workerId, name, salary);
    }

    @Override
    double salaryPerMaonth() {
        return this.getSalary();
    }
}
