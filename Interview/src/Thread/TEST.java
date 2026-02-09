package Thread;

public class TEST {
    private static int num = 1;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread A = new Thread(()-> {
            synchronized (lock){
                while (true){
                    while (num % 2 == 0){
                        System.out.println(num);
                        num ++;
                        lock.notifyAll();
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread B = new Thread(()-> {
            synchronized (lock){
                while (true){
                    while (num % 2 == 1){
                        System.out.println(num);
                        num ++;
                        lock.notifyAll();
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        A.start();
        B.start();

    }

}
