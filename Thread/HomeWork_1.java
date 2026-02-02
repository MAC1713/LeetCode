package Thread;

public class HomeWork_1 {

    // 嘿嘿，name从10开始，倒数到0。宝贝如果你想测试大点数，随便改啦~
    public static int name = 69;

    // waitingThreads记录有多少专用线程在等，达到3就说明没人能处理，该Assistance上了
    public static int waitingThreads = 0;

    // 共享锁，经典Object，简单粗暴
    public static final Object lock = new Object();

    // 通用的NumberThread类，Aria这个点不错，我保留了。divisor决定负责哪个模
    static class NumberThread extends Thread {
        private final int divisor;

        public NumberThread(int divisor) {
            this.divisor = divisor;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // 循环检查能不能处理当前name，不能就等，但要管理count
                    while (name > 0 && name % divisor != 0) {
                        // 进入等待，count++，告诉Assistance我不行了
                        waitingThreads++;
                        // notifyAll唤醒别人，尤其是如果count够了，Assistance该动了
                        lock.notifyAll();
                        try {
                            // 等着被唤醒，可能是别人处理了name变了
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        // 醒了，count--，因为我现在要重新检查condition了
                        waitingThreads--;
                    }

                    // 如果name已经<=0，结束，唤醒所有人走人
                    if (name <= 0) {
                        lock.notifyAll();
                        break;
                    }

                    // 能处理！打印，递减，notifyAll让别人继续
                    System.out.println("Thread-" + divisor + " 处理: " + name);
                    name--;
                    lock.notifyAll();
                }
            }
        }
    }

    static class Assistance extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // 等到count>=3或者name<=0
                    while (waitingThreads < 3 && name > 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    // name<=0，结束
                    if (name <= 0) {
                        lock.notifyAll();
                        break;
                    }

                    // count>=3，兜底处理，打印，递减
                    System.out.println("Assistance 处理其他数: " + name);
                    name--;
                    // notifyAll唤醒专用线程们检查新name
                    lock.notifyAll();
                    try {
                        // 关键fix！处理后wait一下，释放锁，让专用线程醒来--count，避免我自己loop handle下去
                        // 否则count还卡在3，我会无限处理，super bad~
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 启动线程：5、3、2的专用，和Assistance
        // 小彩蛋：如果你加new NumberThread(69).start();，它会负责69的倍数，但name=10太小了，哈哈~
        new NumberThread(5).start();
        new NumberThread(3).start();
        new NumberThread(2).start();
        new Assistance().start();
    }
}