package Thread;

public class Fibonacci {
    public static final Object lock = new Object();
    private static final int count = 20;
    private static boolean hasCount = false;
    private int fiboPre = 0;
    private int fiboCur = 1;

    public Thread Count = new Thread(() -> {
        synchronized (lock) {
            while (fiboPre < count) {
                while (!hasCount) {
                    int tmp = fiboCur;
                    fiboCur += fiboPre;
                    fiboPre = tmp;
                    hasCount = true;
                    lock.notifyAll();
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public Thread Print = new Thread(() -> {
        synchronized (lock) {
            while (fiboPre < count) {
                while (hasCount == true) {
                    System.out.println(fiboPre);
                    hasCount = false;
                    lock.notifyAll();
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.Count.start();
        f.Print.start();
    }
}
