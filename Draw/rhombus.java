package Draw;

import java.util.logging.Level;

public class rhombus {
    public static class Print {
        public void star() {
            System.out.print("*");
        }

        public void space() {
            System.out.print(" ");
        }

        public void nextline() {
            System.out.print("\n");
        }
    }

    public static class Level {
        public void level(int n) {
            int upN = n - 1;
            int downN = n;
            Print print = new Print();
            int t = 0;
            while (upN > 0) {
                for (int j = n - upN; j < n; j++) {
                    print.space();
                    t += 1;
                }

                for (int i = 0; i < n - upN; i++) {
                    t += 1;

                    if (i == 0) {
                        print.star();
                    } else {
                        print.space();
                    }
                }
                for (int i = 0; i < n - upN - 1; i++) {
                    t += 1;

                    if (i == n - upN - 2) {
                        print.star();
                    } else {
                        print.space();
                    }
                }

                upN -= 1;
                print.nextline();
            }
            while (downN > 0) {
                for (int i = 0; i < n - downN; i++) {
                    t += 1;

                    print.space();
                }

                for (int j = n - downN; j < n; j++) {
                    t += 1;

                    if (j == n - downN) {
                        print.star();
                    } else {
                        print.space();
                    }
                }
                for (int j = n - downN + 1; j < n; j++) {
                    t += 1;

                    if (j == n - 1) {
                        print.star();
                    } else {
                        print.space();
                    }
                }

                downN -= 1;
                print.nextline();
            }
            System.out.println(t);

        }
    }

    public static void main(String[] args) {
        Level level = new Level();
//        for (int i = 0; i < 8; i++) {
//            System.out.println(i);
//            level.level(i);
//        }
        int n = 7;
        System.out.println(n);
        level.level(n);
    }
}
