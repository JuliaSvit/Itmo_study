package worker;

public class WorkerFactory {

    private static int workerId = 101;

    public static Worker setWorcer(String name, double salary, TypeOfSalary type){

        switch (type){
            case RATE:
                return new RateWorker(workerId++,name,salary);
            case HOURLY_PAY:
                return new HourlyPayWorker(workerId++,name,salary);
        }
        return null;
    }

}
