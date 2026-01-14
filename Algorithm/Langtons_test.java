package Algorithm;

public class Langtons_test {
    public static void main(String[] args) {
        int h = 100;
        int w = 100;
        int x = w / 2, y = h / 2;
        int t = 1;
        System.out.println(w / 2 + ", " + h / 2);
        for(int i = 1; i < 10; i++){
            if(t == 10){
                break;
            }
            int negative = -1;
            for (int j = 0; j < i; j++) {
                negative *= -1;
                System.out.println(negative);
            }
            for (int j = 0; j < i; j++) {
                x += negative;
                if(t == 10){
                    break;
                }
                System.out.println("x: " + negative + ", " + x + ", " + y);
                t += 1;
            }
            for (int j = 0; j < i; j++) {
                y += negative;
                if(t == 10){
                    break;
                }
                System.out.println("y: " + negative + ", " + x + ", " + y);
                t += 1;
            }
        }
    }
}
