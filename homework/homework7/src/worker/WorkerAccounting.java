package worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WorkerAccounting {

    ArrayList<Worker> workers = new ArrayList<>();

    public void setWorker(String name, double salary, TypeOfSalary type){
        workers.add(WorkerFactory.setWorcer(name, salary, type));
        sortBySalary();
    }

    private void sortBySalary(){
        Collections.sort(this.workers, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public void showAllWorkers(){
        for (Worker worker: workers){
            System.out.println(worker.toString());
        }
    }

    public void showFirstName(int number){
        for (int i = 0; i < number; i++){
            System.out.println(workers.get(i).getName());
        }

    }

    public void showLastID(int number){
        for (int i = workers.size()- number; i < workers.size(); i++){
            System.out.println(workers.get(i).getWorkerId());
        }
    }

}

