package Interview.src.Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class producer_customer {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition Producer = lock.newCondition();
    private static final Condition Customer = lock.newCondition();

    private static Queue<Integer> goods = new LinkedList();
    private static final int goodsMaxSize = 5;

    private static int Rounds = 10;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            lock.lock();
            try {
                while (Rounds > 0) {
                    while (goods.size() <= goodsMaxSize) {
                        int good = 0;
                        goods.add(good + goods.size());
                        Customer.signal();
                    }
                    Rounds--;
                    Producer.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread customer = new Thread(() -> {
            lock.lock();
            try {
                while (Rounds > 0) {
                    while (goods.size() >= goodsMaxSize) {
                        System.out.println("goods.poll() = " + goods.poll());
                        Producer.signal();
                    }
                    Rounds --;
                    Customer.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        producer.start();
        customer.start();
    }


}
