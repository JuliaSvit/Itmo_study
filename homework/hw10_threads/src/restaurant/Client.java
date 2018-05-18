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

    private static volatile int count = 0;

    private boolean orderReady;
    private boolean ready = false;

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

    private void changeReady(){
        this.ready = !this.ready;
    }

    private void order(){
        count++;
        System.out.println(Thread.currentThread().getName() + " - Можно сделать заказ?");
        while (true) {            // проверяем в цкле, перешел ли нужный поток в режим ожидания
            if(this.waiter.getState()== Thread.State.WAITING){// если перешел, то будим >:)
                orderReady = false;
                System.out.println(this.waiter.getName() + " - Да, можно");
                System.out.println(Thread.currentThread().getName() + " - Мне, пожалуйста, даблбургер, катрошку и колу");
                this.waiter.changeReady(); //меняем доп проверку на готовность
                synchronized(monitorW){
                    monitorW.notify();//вот тут будим
                }
                break;
            } else {
                System.out.println(this.waiter.getName() + " - Пока что нет");
            }
        }
    }

    private void waitOrder() throws InterruptedException {
        while (true) {
            synchronized (monitorM) {
                this.monitorM.wait(); // ждём результата
            }
            if (this.ready) {
                this.changeReady();
                System.out.println(Thread.currentThread().getName() + " - Аригато!\n====================================");
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        for (int i = 0; i < 3; i++){
            Thread.currentThread().setName("T-Client" + (i+1));
            client.order();
            client.waitOrder();
        }
    }

    private class Waiter extends Thread{ // Официянт
        private boolean ready = false;

        private void changeReady(){
            this.ready = !this.ready;
        }

        private void getOrder(){
            System.out.println(this.getName() + " - Ваш заказ принят. Спасибо. Ожидайте");
            cooker.changeReady();
            System.out.println(this.getName() + " - Cooker, держи новый заказ");
            synchronized(monitorC){
                monitorC.notify();
            }
        }

        private void putOrder(){
            System.out.println(this.getName() + " - Ваш заказ готов");
            Client.this.changeReady();
            synchronized(monitorM){
                monitorM.notify(); // тут теперь уже будит официант клиента (маленькая месть)
            }
        }

        @Override
        public void run() {
            while(!isInterrupted()){
                synchronized(monitorW){
                    try{
                        monitorW.wait(); // тут засыпает
                        if(this.ready){// кагда разбудили, проверяет специально ли его разбудили или случайно (доп проверка)
                            changeReady();// не забываем вернуть доп проверку назад
                            if(!orderReady){ // проверяем готов ли заказ, если нет, то это только заказали
                                getOrder();
                                while (count==2) {}        // официант занят делом вариант б)
                            } else { // если готов, возвращаем клиенту
                                putOrder();
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

        private void changeReady(){
            this.ready = !this.ready;
        }

        private void getOrder(){
            changeReady();
            System.out.println(this.getName()+ " - Приготовлю в лучших традициях ... хе-хе-хе\n20 минут спустя...");
            orderReady = true; // отмечае что заказ готов
        }

        private void putOrder(){
            if(waiter.getState()== Thread.State.WAITING){//вариант в)
                System.out.println(this.getName()+ " - Waiter, забирай заказ!");
                waiter.changeReady();
                synchronized(monitorW){
                    monitorW.notify(); // будим бедного официанта
                }
            } else { //когда официант занят, еду несёт повар, вариант б)
                System.out.println(this.getName() + " - Ваш заказ готов");
                Client.this.changeReady();
                synchronized(monitorM){
                    monitorM.notify();
                }
            }
        }

        @Override
        public void run() {
            while(!isInterrupted()){
                synchronized(monitorC){
                    try{
                        monitorC.wait();// уснул
                        if(this.ready){ //проснулся и приял заказ
                            getOrder();
                            if (count==3){ // вариант а)
                                System.out.println(this.getName() + " - Кушать подано...");
                                System.exit(0);
                            } else {
                                putOrder();

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