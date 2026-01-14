package Thread;

/**
 * @author mac
 */
public class TestThread {

    public static class one extends Thread {

        public String changeString(String str) {
            return str.replace("o", "O");
        }

        public void run() {
            System.out.println("One");
        }
    }

    public static class two extends Thread {

        public String changeString(String str) {
            return str.replace("e", "E");
        }

        public void run() {
            System.out.println("Two");
        }
    }


    public static void main(String[] args) {
        String str = "Hello World";
        one t1 = new one();
        two t2 = new two();
        t1.start();
        t2.start();
        str = t1.changeString(str);
        str = t2.changeString(str);
        System.out.println(str);
    }
}

