
public class Transaction {
    private static long countId = 1000l;
    private long id;
    private int srcAccId;
    private int dstAccId;
    private int anount;

    public Transaction(int srcAccId, int dstAccId, int anount) {
        this.id = countId++;
        this.srcAccId = srcAccId;
        this.dstAccId = dstAccId;
        this.anount = anount;
    }

    public int getSrcAccId() {
        return srcAccId;
    }

    public int getDstAccId() {
        return dstAccId;
    }

    public int getAnount() {
        return anount;
    }

    public String sendMess(){
        return ("Перевод выполнен успешно!");
    }

    // каждый успешный перевод создаёт Transaction и добавляет его в очередь для потока Notifier
// Notifier берет транзакцию и отправляет пистма её учасникам (пишет в консоль)
}
