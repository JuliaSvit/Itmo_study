package restaurant;

/*
Пиццерия. Есть клиент (main), официант (waiter), повар (cooker).
официант и повар спят, пока не появится клиент.
Клиент составляет заказ и будит официанта, официант, относит заказ повару и будит его.
Повар готовит и возвращает блюдо. Каждый из потоков после выполнения задачи засыпает.

а) Повар просто возвращает блюдо (пишет в консоль).
б) Повар будит клиента и отдает ему блюдо.
в) Повар будит официанта и передает ему блюдо, официант будит клиента и отдает заказ.
*/

public class Client {

    private final static Object monitorW = new Object();
    private final static Object monitorC = new Object();
    private final static Object monitorM = new Object();

    private boolean orderReady = false;
    private boolean readyM = false;

    private Client.Waiter waiter;
    private Client.Cooker cooker;

    public Client(){//сразу создаём новые потоки Waiter и Cooker, и запускаем их
        waiter = this.new Waiter();
        waiter.setName("T-Waiter");
        waiter.setDaemon(true); // отмечаем как daemon(что бы остановился после остановки главного потока)
        cooker = this.new Cooker();
        cooker.setName("T-Cooker");
        cooker.setDaemon(true);
        waiter.start();
        cooker.start();
    }

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        Thread.currentThread().setName("T-Client");
        System.out.println(Thread.currentThread().getName() + " - Можно сделать заказ?");
        while (true) {            // проверяем в цкле, перешел ли нужный поток в режим ожидания
            if(client.waiter.getState()== Thread.State.WAITING){// если перешел, то будим >:)
                System.out.println(client.waiter.getName() + " - Да, можно");
                System.out.println(Thread.currentThread().getName() + " - Мне, пожалуйста, даблбургер, катрошку и колу");
                client.waiter.changeReady(); //меняем доп проверку на готовность
                synchronized(monitorW){
                    monitorW.notify();//вот тут будим
                    break;
                }
            } else {
                System.out.println(client.waiter.getName() + " - Пока что нет");
            }
        }
        synchronized(monitorM){
            monitorM.wait(); // ждём результата
        }
        if(client.readyM){
            client.readyM = false;
            System.out.println(Thread.currentThread().getName() + " - Аригато!");
        }

    }

    private class Waiter extends Thread{ // Официянт
        private boolean ready = false;

        public void changeReady(){
            this.ready = !this.ready;
        }

        @Override
        public void run() {
            while(!isInterrupted()){
                synchronized(monitorW){
                    try{
                        monitorW.wait(); // тут засыпает
                        if(this.ready){// кагда разбудили, проверяет специально ли его разбудили или случайно (доп проверка)
                            if(!orderReady){ // проверяем готов ли заказ, если нет, то это только заказали
                                System.out.println(this.getName() + " - Ваш заказ принят. Спасибо. Ожидайте");
                                changeReady();
                                cooker.changeReady();
                                System.out.println(this.getName() + " - Cooker, держи новый заказ");
                                synchronized(monitorC){
                                    monitorC.notify();
                                }
//                                while (true) {        // официант занят делом вариант б)
//
//                                    }
                            } else { // если готов, возвращаем клиенту
                                System.out.println(this.getName() + " - Ваш заказ готов");
                                changeReady();// не забываем вернуть доп проверку назад
                                readyM = true;
                                synchronized(monitorM){
                                    monitorM.notify(); // тут теперь уже будит официант клиента (маленькая месть)
                                }
                            }
                        }
                    }
                    catch(InterruptedException e){
                        interrupt();
                    }
                }
            }
        }

    }

    private class Cooker extends Thread{ // тут как у официанта, тока повар
        private boolean ready = false;

        public void changeReady(){
            this.ready = !this.ready;
        }
        @Override
        public void run() {
            while(!isInterrupted()){
                synchronized(monitorC){
                    try{
                        monitorC.wait();// уснул
                        if(this.ready){ //проснулся и приял заказ
                            changeReady();
                            System.out.println(this.getName()+ " - Приготовлю в лучших традициях ... хе-хе-хе\n20 минут спустя...");
//                            System.out.println(this.getName()+ " - Ваш заказ готов"); // вариант а)
                            orderReady = true; // отмечае что заказ готов
                            if(waiter.getState()== Thread.State.WAITING){
                                System.out.println(this.getName()+ " - Waiter, забирай заказ!");
                                waiter.changeReady();
                                synchronized(monitorW){
                                    monitorW.notify(); // будим бедного официанта
                                }
                            } else { //когда официант занят, еду несёт повар, вариант б)
                                System.out.println(this.getName() + " - Ваш заказ готов");
                                changeReady();
                                readyM = true;
                                synchronized(monitorM){
                                    monitorM.notify();
                                }
                            }

                        }
                    }
                    catch(InterruptedException e){
                        interrupt();
                    }
                }
            }
        }
    }
}