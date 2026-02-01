package Thread;

public class ABC {

    public static final Object lock = new Object();
    private int number = 0;
    private int max = 10;

    public Thread A = new Thread(() -> {
        synchronized (lock) {
            while (number < max) {
                while (number % 3 == 0) {
                    System.out.print("A");
                    number++;
                    System.out.println(number);
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

    public Thread B = new Thread(() -> {
        synchronized (lock) {
            while (number < max) {
                while (number % 3 == 1) {
                    System.out.print("B");
                    number++;
                    System.out.println(number);
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

    public Thread C = new Thread(() -> {
        synchronized (lock) {
            while (number < max) {
                while (number % 3 == 2) {
                    System.out.print("C");
                    number++;
                    System.out.println(number);
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
        ABC a = new ABC();
        a.A.start();
        a.B.start();
        a.C.start();
    }

}
