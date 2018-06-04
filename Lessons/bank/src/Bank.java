import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Bank {

    private static BlockingQueue<Account> queueAcc = new LinkedBlockingQueue<>();
    private static BlockingQueue<Transaction> notifier = new LinkedBlockingQueue<>();
    private static List<Thread> threadList = new ArrayList<>();

    private static List<User> userList = new ArrayList<>();
    private static List<Account> listAcc = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();

    public static boolean transferMoney(Account src, Account dst, int amount){
//        System.out.println(Thread.currentThread().getName());
        synchronized (src) {
            synchronized (dst) {
                int srcAmount = src.getAmount();
                int dstAmount = dst.getAmount();
                if (srcAmount - amount >= 0) {
                    src.setAmount(srcAmount - amount);
                    dst.setAmount(dstAmount + amount);
                    return true;
                }
                return false;
            }
        }
    }

    private static void sendMesseng(Transaction t){
        for (Account acc: listAcc){
            if (t.getDstAccId()==acc.getId()) {
                System.out.println(t.sendMess()+ " - " + getUserEmail(acc.getUserId()));
            }
        }
    }

    private static String getUserEmail(int userId){
        for (User user: userList){
            if(user.getId()==userId) return user.getEmail();
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        Random ran = new Random();
        for(int i = 0; i < 4; i++){
            User user = new User("Are@net"+i);
            userList.add(user);
            listAcc.add(new Account(user, (int) (10000*(ran.nextInt(10)+1))));
        }
        queueAcc.addAll(listAcc);

        while(!queueAcc.isEmpty()) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Account src = queueAcc.take();
                        Account dst = queueAcc.take();
                        System.out.println(src.getAmount() + " - " + dst.getAmount());
                        int amount = 5000;
                        if(transferMoney(src,dst,amount)){
                            System.out.println(Thread.currentThread().getName());
                            notifier.add(new Transaction(src.getId(),dst.getId(),amount));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadList.add(thread);
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("========");
        for (Thread thread: threadList){
            thread.join();
        }
        while (!notifier.isEmpty()) {
            sendMesseng(notifier.take());
        }
    }

}
