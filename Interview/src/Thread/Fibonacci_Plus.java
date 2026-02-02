package Interview.src.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Fibonacci_Plus {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition Calculate = lock.newCondition();
    private static final Condition Print = lock.newCondition();

    private static final int MaxCount = 10;
    private static boolean hasCount = true;
    private static int fiboPre = 0;
    private static int fiboCur = 1;

    public static void main(String[] args) {
        Thread calculate = new Thread(() -> {
            lock.lock();
            try {
                while (fiboPre < MaxCount){
                    while (!hasCount){
                        int tmp = fiboCur;
                        fiboCur += fiboPre;
                        fiboPre = tmp;
                        hasCount = true;
                        Print.signal();
                    }
                    Calculate.await();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        Thread print = new Thread(() -> {
            lock.lock();
            try {
                while (fiboPre < MaxCount){
                    while (hasCount){
                        System.out.println(fiboPre);
                        hasCount = false;
                        Calculate.signal();
                    }
                    Print.await();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        calculate.start();
        print.start();

    }
}
