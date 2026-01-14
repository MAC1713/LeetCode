package Draw;

public class test {
    public static void main(String[] args) {
        String str[] = {"w", "e", "l", "c", "o", "m", "e"};
        char[] arr = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            arr[i] = s.charAt(0);
        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
