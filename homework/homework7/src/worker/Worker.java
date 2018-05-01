package worker;

import java.util.Date;

/*3) 2. Создать 3 класса: базовый и 2 потомка,
которые описывают некоторых работников с почасовой оплатой (один из предков)
и фиксированой оплатой (второй предок).
Описать в базовом классе абстрактный метод для расчета среднемесячной зарплаты.
Для «почасовщиков» формула для расчета такая:
«среднемесячная зарплата = 20.8*8*ставка в час»,
для работников с фиксированой оплатой «среднемесячная зарплата =
фиксированой месячной оплате».
a)Упорядочить всю последовательность рабочих по убыванию среднемесячной зарплаты.
При совпадении зарплаты – упорядочить данные в алфавитном порядке по имени. Вывести идентификатор работника,
имя и среднемесячную зарплату для всех елементов списка.
b)Вывести первые 5 имен работников из полученого выше списка (задача А).
c)Вывести последние 3 идентификаторы работников из полученого више списка (задача А).*/
abstract public class Worker {

    private int workerId;
    private String name;
    private double salary;
    private Date beginWork;
    private Date endWork;

    public Worker(int workerId, String name, double salary){
        this.workerId = workerId;
        this.name = name;
        this.salary = salary;
        this.beginWork = new Date();
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public Date getBeginWork() {
        return beginWork;
    }

    public void setEndWork(){
        this.endWork = new Date();
    }

    public Date getEndWork() {
        return endWork;
    }

    abstract double salaryPerMaonth();

    public int compareTo(Worker worker){
        if(this == worker) return 0;
        if(this.salaryPerMaonth() == worker.salaryPerMaonth()) return this.name.compareTo(worker.name);
        if(this.salaryPerMaonth() > worker.salaryPerMaonth()) return -1;
        return 1;
    }

    @Override
    public String toString() {
        return workerId + " " + name + " " + this.salaryPerMaonth();
    }
}
