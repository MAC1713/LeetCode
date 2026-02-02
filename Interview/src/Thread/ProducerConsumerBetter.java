package Interview.src.Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerBetter {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();

    private static final Queue<Integer> queue = new LinkedList<>();
    private static final int MAX_SIZE = 5;

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();

                try {
                    while (queue.size() == MAX_SIZE) {
                        notFull.await();
                    }
                    queue.add(i);
                    System.out.println("生产：" + i);
                    notEmpty.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (queue.isEmpty()) {
                        notEmpty.await();
                    }
                    int val = queue.poll();
                    System.out.println("消费：" + val);
                    notFull.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
