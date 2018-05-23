import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Bank {

    private static BlockingQueue<Account> listAcc = new LinkedBlockingQueue<>();

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

    public static void main(String[] args) {
        listAcc.add(new Account(new User("Are@net"),15000));
        listAcc.add(new Account(new User("Bre@net"),9000));
        listAcc.add(new Account(new User("Cre@net"),18000));
        listAcc.add(new Account(new User("Dre@net"),21000));

        while(!listAcc.isEmpty()) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
//                        System.out.println(transferMoney(listAcc.take(),listAcc.take(),17000));
                        transferMoney(listAcc.take(),listAcc.take(),5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

}
