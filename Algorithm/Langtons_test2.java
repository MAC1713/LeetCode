package Algorithm;

public class Langtons_test2 {
    public static void main(String[] args) {
        int h = 100;
        int w = 100;
        int x = 0;
        int y = 0;
        for (int i = 0; i < w + 1; i += w / 2) {
            for (int j = 0; j < h + 1; j += h / 2) {
                System.out.println(x + ", " + y);
                x += w / 2;
                if(x == w){
                    x -= 1;
                }
            }
            x = 0;
            y += h / 2;
            if(y == h){
                y -= 1;
            }
        }
    }
}
