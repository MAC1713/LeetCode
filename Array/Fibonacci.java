package Array;

public class Fibonacci {
    private static int Fibonacci(int n, int before, int after) {
        return n == 1 ? after : Fibonacci(n -= 1, after + before, before);
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Fibonacci(n, 1, 1));
    }
}
