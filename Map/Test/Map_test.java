package Map.Test;

import java.util.*;
import java.util.function.Consumer;

public class Map_test {
    public static void main(String[] args) {
        int a = 10;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < a; i++) {
            map.put(String.valueOf(i), i);
        }
        int[] arr = new int[10];
        System.out.println(map);

        for (int i = 0; i < a; i++) {
            System.out.print(map.get(String.valueOf(i)) + " ");
        }

        System.out.print("\narr: ");
        for (int i = 0; i < a; i++) {
            arr[i] = map.put(String.valueOf(i), i + 10);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\nshift:");
        for (int i = 0; i < a; i++) {
            System.out.print(map.get(String.valueOf(i)) + " ");
        }

        System.out.print("\nremove: ");
        map.remove(String.valueOf(a - 1));
        System.out.println(map);

        System.out.print("contain: ");
        boolean[] contains = new boolean[a];
        for (int i = 0; i < a; i++) {
            contains[i] = map.containsKey(String.valueOf(i));
        }
        for (int i = 0; i < a; i++) {
            System.out.print(contains[i] + " ");
        }

        System.out.print("\nkeys: ");
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        keys.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                values.forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer + " " + s);
                    }
                });
            }
        });

    }
}
